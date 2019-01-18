package imageOperation;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
public class imageOperation {
	public static double[] getMatchCoordinate(String item, String src) {
	    // TODO Auto-generated method stub
		//item: 需要匹配的图像模板全路径
		//src： 匹配的源图片全路径
		String path = System.getProperty("user.dir") + "/";
	    String result = item.split("[\\\\/]")[item.split("[\\\\/]").length - 1] + "_" + src.split("[\\\\/]")[src.split("[\\\\/]").length - 1];
	    result = path + "test-output/result_" + result.replaceAll(".jpg", "").replaceAll(".png", "") + ".png";
	    MinMaxLocResult loc = matchImage(item, src, result, Imgproc.TM_CCOEFF_NORMED,1);
	    System.out.println("max val: " + loc.maxVal + " min val: " + loc.minVal);
	    
	    Point p = loc.maxLoc;
	    
	    Mat g_tem = Imgcodecs.imread(item);
	    double width = g_tem.cols();
	    double height = g_tem.rows();
	    System.out.println(result);
	    System.out.println("origin x: " + p.x + " origin y: " + p.y + " size:" + width + " " + height);
	    double[] r = {p.x + width/2,p.y + height/2};
	    return r; //坐标{x,y}
	}
	
	public static MinMaxLocResult matchImage(String item, String src, String result,int method,int maxOrMin) {
		//maxOrmin: 取最大数或最小数，取决于匹配算法，如SQDIFF则取最小值，CCORR和CCOEFF取最大
	    // TODO Auto-generated method stub
	    /* TM_SQDIFF 平方差匹配法：该方法采用平方差来进行匹配；最好的匹配值为0；匹配越差，匹配值越大。 
		   TM_CCORR 相关匹配法：该方法采用乘法操作；数值越大表明匹配程度越好。 
		   TM_CCOEFF 相关系数匹配法：1表示完美的匹配；-1表示最差的匹配。 
		   TM_SQDIFF_NORMED 归一化平方差匹配法。 
		   TM_CCORR_NORMED 归一化相关匹配法。 
		   TM_CCOEFF_NORMED 归一化相关系数匹配法。
	     */
	    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	    Mat g_tem = Imgcodecs.imread(item);
	    Mat g_src = Imgcodecs.imread(src);
	 
	    int result_rows = g_src.rows() - g_tem.rows() + 1;
	    int result_cols = g_src.cols() - g_tem.cols() + 1;
	    //System.out.println(result_rows + " " +result_cols);
	    Mat g_result = new Mat(result_rows, result_cols, CvType.CV_32FC1);
	    Imgproc.matchTemplate(g_src, g_tem, g_result, method); // 归一化平方差匹配法

	    Core.normalize(g_result, g_result, 0, 1, Core.NORM_MINMAX, -1, new Mat());
	    Point matchLocation = new Point();
	    MinMaxLocResult mmlr = Core.minMaxLoc(g_result);
	    //System.out.println(mmlr.maxVal);
	    if (maxOrMin == 1){
	    	matchLocation = mmlr.maxLoc; // 此处使用maxLoc还是minLoc取决于使用的匹配算法
	    }
	    else{
	    	matchLocation = mmlr.minLoc;
	    }
	    
	    Imgproc.rectangle(g_src, matchLocation,
	        new Point(matchLocation.x + g_tem.cols(), matchLocation.y + g_tem.rows()),
	        new Scalar(0, 0, 0, 0));
	    
	    Imgcodecs.imwrite(result, g_src);
	    
	    return mmlr;
	}
	

	/**
	 * Compare that two images is similar using histogram  
	 * @author minikim
	 * @param filename1 - the first image
	 * @param filename2 - the second image
	 * @return integer - 1 if two images are similar, 0 if not 
	 */
	public static int compareHistogram(String filename1, String filename2) {
		int retVal = 0;
		
		long startTime = System.currentTimeMillis();
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		// Load images to compare
		Mat img1 = Imgcodecs.imread(filename1);
		Mat img2 = Imgcodecs.imread(filename2);
		
		Mat hsvImg1 = new Mat();
		Mat hsvImg2 = new Mat();
		
		// Convert to HSV
		Imgproc.cvtColor(img1, hsvImg1, Imgproc.COLOR_BGR2HSV);
		Imgproc.cvtColor(img2, hsvImg2, Imgproc.COLOR_BGR2HSV);
		
	    // Set configuration for calchist()
		List<Mat> listImg1 = new ArrayList<Mat>();
	    List<Mat> listImg2 = new ArrayList<Mat>();
	    
	    listImg1.add(hsvImg1);
	    listImg2.add(hsvImg2);
	    
	    MatOfFloat ranges = new MatOfFloat(0,255);
	    MatOfInt histSize = new MatOfInt(50);
	    MatOfInt channels = new MatOfInt(0);

	    // Histograms
	    Mat histImg1 = new Mat();
	    Mat histImg2 = new Mat();
	    
	    // Calculate the histogram for the HSV imgaes
	    Imgproc.calcHist(listImg1, channels, new Mat(), histImg1, histSize, ranges);
	    Imgproc.calcHist(listImg2, channels, new Mat(), histImg2, histSize, ranges);
	    
	    Core.normalize(histImg1, histImg1, 0, 1, Core.NORM_MINMAX, -1, new Mat());
	    Core.normalize(histImg2, histImg2, 0, 1, Core.NORM_MINMAX, -1, new Mat());

	    // Apply the histogram comparison methods
	    // 0 - correlation: the higher the metric, the more accurate the match "> 0.9"
	    // 1 - chi-square: the lower the metric, the more accurate the match "< 0.1"
	    // 2 - intersection: the higher the metric, the more accurate the match "> 1.5"
	    // 3 - bhattacharyya: the lower the metric, the more accurate the match  "< 0.3"
	    double result0, result1, result2, result3;
	    result0 = Imgproc.compareHist(histImg1, histImg2, 0);
	    result1 = Imgproc.compareHist(histImg1, histImg2, 1);
	    result2 = Imgproc.compareHist(histImg1, histImg2, 2);
	    result3 = Imgproc.compareHist(histImg1, histImg2, 3);
	    
	    System.out.println("Method [0] " + result0);
	    System.out.println("Method [1] " + result1);
	    System.out.println("Method [2] " + result2);
	    System.out.println("Method [3] " + result3);
	    
	    // If the count that it is satisfied with the condition is over 3, two images is same.
	    int count=0;
	    if (result0 > 0.9) count++;
	    if (result1 < 0.1) count++;
	    if (result2 > 1.5) count++;
	    if (result3 < 0.3) count++;
	    System.out.println("count: " + count);
	    if (count >= 3) retVal = 1;
	    
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("estimatedTime=" + estimatedTime + "ms");
		
		return retVal;
	}
}

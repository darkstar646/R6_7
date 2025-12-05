
public class CircleAndLine extends MyFrame2{
	
	public void drawCircle(int cx, int cy, int r) {
    	double x;
    	double y;
    	for(int i=0; i<360; i++) {
    		x = r*Math.cos(Math.toRadians(i))+cx;
    		y = r*Math.sin(Math.toRadians(i))+cy;
    		
    		setColor(0,0,0);
    		fillRect((int)x,(int)y,1,1);
    	}	
    }
	
	//円周上に 1 〜 12 の数字を描画するメソッド
	public void drawNumber(int cx, int cy, int r) {
		double x;
    	double y;
    	int deg = 30;
    	for(int i=0; i<12; i++) {
    		x = (r+20)*Math.cos(Math.toRadians(-90+deg+deg*i))+cx-5;
    		y = (r+20)*Math.sin(Math.toRadians(-90+deg+deg*i))+cy+3;
    		
    		setColor(0,0,0);
    		drawString(""+(i+1), (int)x, (int)y, 20);
    	}
	}
	
	//円周の内部に，主目盛と補助目盛の全てを描画するメソッド
	public void drawScale(int cx, int cy, int r) {
		double x0, y0;
		double x1, y1;
		double x2, y2;
		
    	int deg = 6;
    	for(int i=0; i<60; i++) {
    		x0 = r*Math.cos(Math.toRadians(deg*i))+cx;
    		y0 = r*Math.sin(Math.toRadians(deg*i))+cy;
    		x1 = (r*0.9)*Math.cos(Math.toRadians(deg*i))+cx;
    		y1 = (r*0.9)*Math.sin(Math.toRadians(deg*i))+cy;
    		x2 = (r*0.95)*Math.cos(Math.toRadians(deg*i))+cx;
    		y2 = (r*0.95)*Math.sin(Math.toRadians(deg*i))+cy;
    		
    		setColor(0,0,0);
			if(i%5==0) {
				drawLine(x0,y0,x1,y1);
			}else {
				drawLine(x0,y0,x2,y2);
			}  		
    	}
	}
	
	//hとmを入力として，長針と短針を描画するメソッド
	public void drawHand(int cx, int cy, int r, int h, int m, int s) {
		double deg_hour = -90+30*h+30*m/60;
		double deg_min = -90+6*m;
		double deg_sec = -90+6*s;
		double xh,yh;
		double xm,ym;
		double xs,ys;
		
		xh = (r*0.7)*Math.cos(Math.toRadians(deg_hour))+cx;
		yh = (r*0.7)*Math.sin(Math.toRadians(deg_hour))+cy;
		xm = (r*0.9)*Math.cos(Math.toRadians(deg_min))+cx;
		ym = (r*0.9)*Math.sin(Math.toRadians(deg_min))+cy;
		xs = (r*0.9)*Math.cos(Math.toRadians(deg_sec))+cx;
		ys = (r*0.9)*Math.sin(Math.toRadians(deg_sec))+cy;
		
		setColor(0,0,0);
		drawLine(cx,cy,xh,yh);
		drawLine(cx,cy,xm,ym);
		setColor(225,0,0);
		drawLine(cx,cy,xs,ys);
	}
	
	 public void drawClock(int cx, int cy, int r, int h, int m, int s) {
		 drawCircle(cx, cy, r);
		 drawNumber(cx, cy, r);
		 drawScale(cx, cy, r);
		 drawHand(cx, cy, r, h, m, s);
	 }
	 
	 public void run() {
		 setSize(400,400);
		 int h = 37025447%12;
		 int m = 37025447%60;
		 int s =0;
		 
		 
		 for(int i=0; i<5; i++) {
			 for(int j=0; j<60; j++) {
				 clear();
				 drawClock(200,200,100,h,m+i,s+j);
				 
				 setColor(0,0,0);
				 drawString(""+h+":"+(m+i)+":"+(s+j), 10, 370,40);
				 
				 sleep(0.3);
				 
				 System.out.print(""+h);
				 System.out.print(":");
				 System.out.print(""+(m+i));
				 System.out.print(":");
				 System.out.print(""+(s+j));
				 System.out.println();
			 }
			 sleep(0.1);
			 System.out.println(""+(i+1)+"分経過");
		 }
		 sleep(0.1); 		 
	 }
	 
	 public static void main(String[] args) {
	        new CircleAndLine();
	    }
}


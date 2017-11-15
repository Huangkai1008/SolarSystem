package com.huangkai.solar;

import com.huangkai.util.GameUtil;

import java.awt.*;

/**
 *行星类<---太阳类
 */
public class Planet extends Star {


    //行星沿着椭圆轨道运行：长轴，短轴，速度，围绕恒星
    double longAxis;    //椭圆长轴
    double shortAxis;   //椭圆短轴
    double speed;       //飞行的速度
    double degree;
    Star center;

    boolean satellite;

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        move();
        if (!satellite) {
            drawTrace(g);
        }
    }

    /**
     * 画出行星绕卫星轨迹
     */
    public void drawTrace(Graphics g){
        double ovalX, ovalY, ovalWidth, ovalHeight;

        ovalWidth = longAxis * 2;
        ovalHeight = shortAxis * 2;
        ovalX = center.x + center.width/2 - longAxis;
        ovalY = center.y + center.height/2 - shortAxis;

        Color c = g.getColor();
        g.setColor(Color.blue);
        g.drawOval((int)ovalX, (int)ovalY, (int)ovalWidth, (int)ovalHeight);
        g.setColor(c);
    }

    /**
     * 行星运行
     */
    public void move(){
         //沿着椭圆轨迹飞行
        x = (center.x + center.width/2 ) + longAxis*Math.cos(degree);
        y = (center.y + center.width/2 ) + shortAxis*Math.sin(degree);

        degree += speed;
    }

    public Planet(Star center,String imgpath, double longAxis,
                  double shortAxis, double speed) {
        super(GameUtil.getImage(imgpath));

        this.center = center;
        this.x = center.x + longAxis;
        this.y = center.y;


        this.longAxis = longAxis;
        this.shortAxis = shortAxis;
        this.speed = speed;

        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
    }

    public Planet(Star center,String imgpath, double longAxis,
			double shortAxis, double speed,boolean satellite) {
		this(center, imgpath, longAxis, shortAxis, speed);
		this.satellite = satellite;
	}

    public Planet(Image img, double x, double y) {
        super(img, x, y);
    }

    public Planet(String imgpath , double x, double y) {
        super(imgpath, x, y);
    }
}

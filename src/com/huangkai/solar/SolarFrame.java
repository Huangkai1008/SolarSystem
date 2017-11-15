package com.huangkai.solar;

import com.huangkai.util.Constant;
import com.huangkai.util.GameUtil;
import com.huangkai.util.MyFrame;

import java.awt.*;

/**
 * 太阳系的主窗口
 */
public class SolarFrame extends MyFrame{
    Image bg = GameUtil.getImage("images/bg.jpg");
    Star sun = new Star("images/sun.jpg", Constant.GAME_WIDTH/2,Constant.GAME_HEIGHT/2);
    Planet earth = new Planet(sun,"images/earth.jpg",150,100,0.1);

    @Override
    public void paint(Graphics g) {
         g.drawImage(bg,0,0,null);
         sun.draw(g);
         earth.draw(g);
    }

    public static void main(String[] args) {
        new SolarFrame().launchFrame();
    }
}

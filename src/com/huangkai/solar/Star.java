package com.huangkai.solar;

import com.huangkai.util.GameUtil;

import java.awt.*;

public class Star {
    Image img;
    double x,y;

    public void draw(Graphics g){
        g.drawImage(img, (int)x, (int)y,null);
    }

    public Star(String imgpath, double x, double y) {
        this.img = GameUtil.getImage(imgpath);
        this.x = x;
        this.y = y;
    }
}

package com.zy.zg6.designmode;

import android.content.Context;
import android.widget.ImageView;

/**
 * @author:zhangyue
 * @date:2021/4/1
 */
public class BuilderMode implements Cloneable {
    private String imgSavePath;
    private boolean isRadius;

    public BuilderMode(String imgSavePath,boolean isRadius){
        this.imgSavePath=imgSavePath;
        this.isRadius=isRadius;
    }

    public void loadImg(Context context, String url, ImageView imageView){

    }


    public static class Builder{
        private String imgSavePath;
        private boolean isRadius;

        public Builder setSavePath(String path){
            imgSavePath=path;
            return this;
        }

        public Builder setIsRadius(boolean _isRadius){
            isRadius=_isRadius;
            return this;
        }

        public BuilderMode build(){
            return new BuilderMode(imgSavePath,isRadius);
        }
    }
}

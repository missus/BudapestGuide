/*
 * Created by Karolin Fornet.
 * Copyright (c) 2017.  All rights reserved.
 */

package com.example.android.budapestguide;

public class Sight {
    private int mName;
    private int mEnglishName = EMPTY;
    private int mType;
    private int mUrl = EMPTY;
    private int mImageId = EMPTY;
    private static int EMPTY = -1;

    public int getName() {
        return mName;
    }

    public int getEnglishName() {
        return mEnglishName;
    }

    public int getType() {
        return mType;
    }

    public int getUrl() {
        return mUrl;
    }

    public int getImageId() {
        return mImageId;
    }

    public Sight(int name, int type, int url) {
        mName = name;
        mType = type;
        mUrl = url;
    }

    public Sight(int name, int englishName, int type, int url) {
        mName = name;
        mEnglishName = englishName;
        mType = type;
        mUrl = url;
    }

    public Sight(int name, int englishName, int type, int url, int imageId) {
        mName = name;
        mEnglishName = englishName;
        mType = type;
        mUrl = url;
        mImageId = imageId;
    }

    public boolean hasImage() {
        return mImageId != EMPTY;
    }

    public boolean hasEnglishName() {
        return mEnglishName != EMPTY;
    }

    public boolean hasUrl() {
        return mUrl != EMPTY;
    }
}

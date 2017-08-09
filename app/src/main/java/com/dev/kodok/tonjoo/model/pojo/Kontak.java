package com.dev.kodok.tonjoo.model.pojo;

/**
 * Created by root on 08/08/17.
 */

public class Kontak {
    public String id, fist_name, last_name, email, gender, avatar;


    public Kontak(Builder builder){
        id = builder.mId;
        fist_name = builder.mFist_name;
        last_name = builder.mLast_name;
        email = builder.mEmail;
        gender = builder.mGender;
        avatar = builder.mAvatar;
    }

    public static class Builder {
        private String mId, mFist_name, mLast_name, mEmail, mGender, mAvatar;

        public Builder setId(String id) {
            mId = id;
            return Builder.this;
        }

        public Builder setFist_name(String fist_name) {
            mFist_name = fist_name;
            return Builder.this;
        }

        public Builder setLast_name(String last_name) {
            mLast_name = last_name;
            return Builder.this;
        }

        public Builder setEmail(String email) {
            mEmail = email;
            return Builder.this;
        }

        public Builder setGender(String gender) {
            mGender = gender;
            return Builder.this;
        }

        public Builder setAvatar(String avatar) {
            mAvatar = avatar;
            return Builder.this;
        }

        public Kontak build() {
            return new Kontak(Builder.this);
        }
    }

}

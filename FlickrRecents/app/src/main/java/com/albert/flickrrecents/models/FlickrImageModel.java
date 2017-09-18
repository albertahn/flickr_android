package com.albert.flickrrecents.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by albert on 9/17/17.
 */

public class FlickrImageModel {
        @SerializedName("id")
        @Expose
        private String id;

        @SerializedName("owner")
        @Expose
        private String owner;


        @SerializedName("secret")
        @Expose
        private String secret;



        @SerializedName("server")
        @Expose
        private String server;

        @SerializedName("farm")
        @Expose
        private String farm;

        @SerializedName("title")
        @Expose
        private String title;

    @SerializedName("ispublic")
    @Expose
    private String ispublic;

    @SerializedName("isfriend")
    @Expose
    private String isfriend;

    @SerializedName("isfamily")
    @Expose
    private String isfamily;


    /**
         *
         * @return
         * The id
         */
        public String getId() {
            return id;
        }

    /**
     *
     * @param id
     * The success
     */
        public void setId(String id) {
             this.id=id;
        }


    /**
     *
     * @return
     * The owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     *
     * @param owner
     * The success
     */
    public void setOwner(String owner) {
        this.owner=owner;
    }

    /**
     *
     * @return
     * The secret
     */
    public String getSecret() {
        return secret;
    }

    /**
     *
     * @param secret
     * The success
     */
    public void setSecret(String secret) {
        this.secret=secret;
    }

    /**
     *
     * @return
     * The server
     */
    public String getServer() {
        return server;
    }

    /**
     *
     * @param server
     * The success
     */
    public void setServer(String server) {
        this.server=server;
    }

    /**
     *
     * @return
     * The farm
     */
    public String getFarm() {
        return farm;
    }

    /**
     *
     * @param farm
     * The success
     */
    public void setFarm(String farm) {
        this.farm=farm;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title=title;
    }

    /**
     *
     * @return
     * The ispublic
     */
    public String getIspublic() {
        return ispublic;
    }

    /**
     *
     * @param ispublic
     * The ispublic
     */
    public void setIspublic(String ispublic) {
        this.ispublic=ispublic;
    }

    /**
     *
     * @return
     * The isfriend
     */
    public String getIsfriend() {
        return isfriend;
    }

    /**
     *
     * @param isfriend
     * The isfriend
     */
    public void setIsfriend(String isfriend) {
        this.isfriend=isfriend;
    }

    /**
     *
     * @return
     * The isfamily
     */
    public String getisfamily() {
        return isfamily;
    }

    /**
     *
     * @param isfamily
     * The isfamily
     */
    public void setisfamily(String isfamily) {
        this.isfamily=isfamily;
    }


    /*
    * get image url format: https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg
    * */
    public String getImageURL(){

        return "https://farm"+farm+".staticflickr.com/"+server+"/"+id+"_"+secret+".jpg";
    }



}

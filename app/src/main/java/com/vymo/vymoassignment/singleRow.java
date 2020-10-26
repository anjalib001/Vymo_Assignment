package com.vymo.vymoassignment;

public class singleRow {


    public String getPr_number() {
        return pr_number;
    }

    public void setPr_number(String pr_number) {
        this.pr_number = pr_number;
    }

    public String getPull_title() {
        return pull_title;
    }

    public void setPull_title(String pull_title) {
        this.pull_title = pull_title;
    }

    String pull_title;


    String pr_number;


    public String getPatch_url() {
        return patch_url;
    }

    public void setPatch_url(String patch_url) {
        this.patch_url = patch_url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    String status;
    String patch_url;
    public singleRow(String pull_title, String pr_number, String  status, String patch_url)
    {
        this.pull_title=pull_title;
        this.pr_number=pr_number;
        this.status=status;
        this.patch_url=patch_url;
    }


}

package com.example.attack.entity;

import java.util.List;

/**
 * Created by zjb on 2019/5/13.
 */
public class SignUp {


    /**
     * data : {"accountBalance":0,"couponList":[],"isAgent":0,"uid":10565033,"userName":"zjba8767"}
     * errorcode : 200
     * message : 操作成功
     */

    private DataBean data;
    private int errorcode;
    private String message;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * accountBalance : 0
         * couponList : []
         * isAgent : 0
         * uid : 10565033
         * userName : zjba8767
         */

        private int accountBalance;
        private int isAgent;
        private int uid;
        private String userName;
        private List<?> couponList;

        public int getAccountBalance() {
            return accountBalance;
        }

        public void setAccountBalance(int accountBalance) {
            this.accountBalance = accountBalance;
        }

        public int getIsAgent() {
            return isAgent;
        }

        public void setIsAgent(int isAgent) {
            this.isAgent = isAgent;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public List<?> getCouponList() {
            return couponList;
        }

        public void setCouponList(List<?> couponList) {
            this.couponList = couponList;
        }
    }
}

package com.example.attack.entity;

/**
 * Created by zjb on 2019/5/13.
 */
public class CaptchaBean {


    /**
     * data : data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAHgAAAAoCAMAAAACNM4XAAAAw1BMVEXz+/5/XUmtr86u3q22rMm7odjEs9/Zl5zY39rX19ner63b267W09CObmyVdn7Hv7rk5+ezmMaqmIyNcF+chHa2qaOVe225rKPBuLWrmpHMx8fSpKCWcWKKZ1WozaCWnXuKfWKYfYGHZ1uQcm67qMyhiJSGZVqynbmdf5CskLSVfW2gjX/BvrWrnpGKbVvMzse2rqOKZFPCiIegcmiKbFWhjG6Va12WfGLNj5G3gXytnHvPy6GcrYe4q4jEu5Suhnukh6LON1oFAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAEX0lEQVRYha2XDXubNhCAdWAMGBxUQaJlX026NEu7tqs3u1njtd3//1W7OwkhQGDc9h4eGxtJr+5ThxBfK2Al/DSKYyHyKM8FXlGUZd2jLPN/nc9FspigOjCRCS48Mt0tI+ckAW42pW0LjllfBncoc7OEzPOGZGDyzCwExwac0dwsixzYyGmwhx9wZyc7MGqMnKgDL0VOcU8s0Te141pycG4iEr587JCbAU1OeqNGYNGCI49rjd3+WIs1Xwwek2kJWsnn8q6nyTzczZmUtUcOgZHcLmL9a3c9o/MimQVvWCzY+NeJGVYKkaJ4M7rPM8Hl9qKS/MikE4PjGEBDDeWAqxtN1I7cA3ej+7JajcHPtnABqq4sOUcu5YeAXwG5oHSPK5Te/UXfQbACuRy8hQbZCipvIeJyga7cg9Ydtd7temv64BK0CMoILISslRQSmsYalVdAOws09HPk1A1r4cJAwd+gJnxc6qYWNk5G4BXDO7m8hKs816hZ3S1D3BJuEFnBLSjL5Qio9vsDGmFAJlLZADzho01RjIKNqT1y/kONxszzBsm63e0GiAzP6Z/6xW8gExYGHw7wYb+XffKGQBK0OuxrQdwh2TB9cp5jYKFmsi4bFxnMFfXNDeaSRpU9xxWHGk0NjyL9x0bwxjO4ggN8DnADYJFfwzVcoQkxkBrLNemr0cs6Se5ebl9wQJhiioG72x3g40fjGmckvpW8J2ODU2CKHwXX6GIljcpt2ZB1U98/Q8f9DqUlC9qOLOHxA6gmlDkNqbxIY1wM4/oKSi0RrYVfrkp4wBB7eatqzUnQgosnpVvrDOQzqnxY5GMy4I/Xl5hSZGzVL5Py1UUl1rdQNhaMhUXDsUDzoBfKMbsoKP2OhQdeDdNoICWSm6YclOckkWJ9B0o5jeN/959q/KNRCiBQIKnifOlx56g4nkJaNmpwLIgHeL3O/rh4kyE4ZlMfnwDLK65fB5yM6X5/v4VxAZkUjK9SAwy5Est4dvf2HSa61bg47h+PRfGpCalL5AdQ9/+5As+WnlNaw08/02nEXGoibB8B6s1bgHdtF0iHB+lZggqfBugbQLtRsbPckzr/gi7j/pmZbQPDZnj9p8i4741dn1FNRE2SVAoPNLcrHjIPd2aOuD9vOyf5/r3E/oNaEMNsm5NR8TXgV6Aq/49TQQ2wITKFBHXJXquI3SpfA3CwFJHG4VbAD5zUa2DAkM3JNAQLC2Zmp/AqFDeTbZl5E6EZDOUPG8xgT8SYTO2a1F6zavbkaXyGUFthPL4yagMYss09o5WL6j7YF2+R5WRfhCWbM9V1yNPgtnU5laF+QxhEW/ObPiK20gH5xvd4Cz4p6RCM++yTRQtuG5/eO0EUeW8lZ7yGFYVpRUjWLRg/TPwNNyXG4IGsF2qM1LQjC0tGNoGT5ExwttjUaQhsnqRT3DkZgM19YCspg93q/oAkTUfe/75gb/0eeO6F95vBBUvq/fTAX/PauRRsgovBmBL/A681ObobqceUAAAAAElFTkSuQmCC
     * errorcode : 200
     * message : 操作成功
     */

    private String data;
    private int errorcode;
    private String message;

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
}

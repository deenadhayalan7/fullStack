package com.eweb.giftbackend.utils;

// import java.net.http.HttpHeaders;
import java.util.Arrays;
import java.util.List;

// import org.springframework.http.HttpMethod;
// 
import static org.springframework.http.HttpHeaders.*;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.HEAD;
import static org.springframework.http.HttpMethod.PATCH;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;


public class MyConstant {
    //Request Mapping
    public static final String AUTH="/api/v1/auth";
    public static final String USER="/api/v1/user";

    //End Points
    public static final String REGISTER="/register";
    public static final String LOGIN="/login";
    public static final String USERLIST="/list";

    //Web Security
    public static final List<String> ORIGINS=Arrays.asList("http://localhost:4000");
    public static final List<String> HEADERS=Arrays.asList(AUTHORIZATION,CONTENT_TYPE);
    public static final List<String> METHODS=Arrays.asList(GET.name(),POST.name(),
    PUT.name(),PATCH.name(),DELETE.name(),HEAD.name());
 
    //JsonwebToken
    public static final String SWAGGER_LOCAHOST_URL = "http://localhost:8181";
    public static final String SWAGGER_SECURITY_SCHEME_NAME = "bearerAuth";
    public static final String SWAGGER_SCHEME = "bearer";
    public static final String SWAGGER_BEARER_FORMAT = "JWT";
    public static final String SWAGGER_DESCRIPTION="Produce a Json Web Token.";

    //mbc
    public static final String GIFTS="/api/v1/users/gift";

    public static final String CART = "/api/v1/users/cart";
    public static final String SHOWCART= "/all";
    public static final String ADDCART= "/add";
    // public static final List<String> ORGINS=Arrays.asList("http://localhost:4000");
    // public static final List<String> HEADERS=Arrays.asList(AUTHORIZATION, CONTENT_TYPE);
    // public static final List<String> METHODS=Arrays.asList(GET.name(),POST.name(),PUT.name(),PATCH.name(),DELETE.name(), HttpMethod.HEAD.name());


    public static final String SHOWGIFT="/all";
    public static final String ADDGIFT="/add";
    public static final String DELETEGIFT= "/delete";
    public static final String UPDATEGIFT= "/update";
    //mbc end
    public static final String CARTLIST = "/clist";
    public static final String PRODUCTIST = "/plist";
    public static final String ORDERLIST = "/olist";
    public static final String DELETECART = "/dcart";
 }
 
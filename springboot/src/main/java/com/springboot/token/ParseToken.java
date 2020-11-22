package com.springboot.token;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class ParseToken {
    public static void main(String[] args) {
        String compactJws="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLlsI_nmb0iLCJpYXQiOjE2MDYwMzEwODEsImV4cCI6MTYwNjAzMTE0MH0.WQoJ5wb9nOV0fPWe0xaTKw0U3VUApbKaK-E4q_2OUcc";
        try {
        	Claims claims = Jwts.parser().setSigningKey("itcast").parseClaimsJws(compactJws).getBody();
            System.out.println("id:"+claims.getId());
            System.out.println("subject:"+claims.getSubject());
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

            System.out.println("签发时间:"+sdf.format(claims.getIssuedAt()));
            System.out.println("过期时间:"+sdf.format(claims.getExpiration()));
            System.out.println("当前时间:"+sdf.format(new Date()) );
        }
        catch (Exception e) {
        	System.out.println("触发异常 : "+e);
        }

}
}

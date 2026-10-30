package com.supply_chain_base_operation.utilities;

import com.supply_chain_base_operation.constants.SystemConstant;
import com.supply_chain_base_operation.models.Role;
import com.supply_chain_base_operation.models.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Component
public class JwtUtility {

    private final Key key = Keys.hmacShaKeyFor(SystemConstant.JWT_SECRET_PASSWORD.getBytes());

    public String generateJwtToken(User user){
        String email = user.getEmail();
        List<Role> roles = user.getRoles();
        List<String> roleNames = new ArrayList<>();
        for (Role role : roles){
            roleNames.add(role.getRoleName());
        }
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("email" , email);
        claims.put("roles" , roleNames);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + SystemConstant.JWT_TOKEN_EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }
}

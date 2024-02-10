package com.eweb.giftbackend.config;

import java.io.IOException;
// import java.net.http.HttpHeaders;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.eweb.giftbackend.utils.JwtUtil;

import io.micrometer.common.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationConfig extends OncePerRequestFilter{
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    @Override
    protected void doFilterInternal(
        @NonNull HttpServletRequest request, 
        @NonNull HttpServletResponse response,
        @NonNull FilterChain filterChain)
            throws ServletException, IOException {
                //HttpHeaders.AUTHORIZATION
        final String authHeader=request.getHeader(HttpHeaders.AUTHORIZATION);
        final String token;
        final String username;
         if(authHeader==null||!authHeader.startsWith("Bearer"))
         {
            filterChain.doFilter(request,response);
            return;
         }
         token=authHeader.substring(7);
         username=jwtUtil.extractUsername(token); 
         if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails= this.userDetailsService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken( userDetails,
            null,userDetails.getAuthorities());
            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authToken);
         }
         filterChain.doFilter(request, response);
    }
}


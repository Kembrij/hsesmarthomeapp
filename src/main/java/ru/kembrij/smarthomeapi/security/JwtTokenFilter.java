package ru.kembrij.smarthomeapi.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;
import ru.kembrij.smarthomeapi.util.JwtUtil;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends GenericFilterBean {

    private static final String AUTH_HEADER_PREFIX = "Bearer ";

    private static final String AUTHORITIES_CLAIM = "Authorization";
    private final JwtTokenProvider jwtTokenProvider;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        var token = getTokenFromRequest((HttpServletRequest) servletRequest);
        if (token != null && jwtTokenProvider.validateAccessToken(token)) {
            var claims = jwtTokenProvider.getAccessClaims(token);
            var jwtAuthentication = JwtUtil.generate(claims);
            jwtAuthentication.setAuthenticated(true);
            SecurityContextHolder.getContext().setAuthentication(jwtAuthentication);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }


    @Nullable
    private String getTokenFromRequest(HttpServletRequest request) {
        var bearer = request.getHeader(AUTHORITIES_CLAIM);
        if (StringUtils.hasText(bearer) && bearer.startsWith(AUTH_HEADER_PREFIX)) {
            return bearer.substring(AUTH_HEADER_PREFIX.length());
        }
        return null;
    }
}


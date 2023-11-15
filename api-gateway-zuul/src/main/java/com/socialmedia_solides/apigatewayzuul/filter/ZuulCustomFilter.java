package com.socialmedia_solides.apigatewayzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
public class ZuulCustomFilter extends ZuulFilter {

    private static final String ZULL_HEADER_USER_ID = "clientId";

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {


            String onlineUser = SecurityContextHolder.getContext().getAuthentication().getName();
            RequestContext ctx = RequestContext.getCurrentContext();
            ctx.addZuulRequestHeader(ZULL_HEADER_USER_ID, onlineUser);


        return null;
    }
}

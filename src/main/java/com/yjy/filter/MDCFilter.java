package com.yjy.filter;

import com.yjy.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.servlet.*;
import java.io.IOException;

public class MDCFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(MDCFilter.class);

    private static final String TRACE_ID = "traceId";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if (logger.isDebugEnabled()) {
            logger.debug("mdc filter init... ...");
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            MDC.put(TRACE_ID, UUIDUtil.generateUUID());

            chain.doFilter(request, response);
        } catch (Exception e) {
        } finally {
            MDC.remove(TRACE_ID);
        }
    }

    @Override
    public void destroy() {
        if (logger.isDebugEnabled()) {
            logger.debug("mdc destroy init... ...");
        }
    }

}

package com.capgemini.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public final class XSSFilter implements Filter {

  private static final Logger LOGGER = LoggerFactory.getLogger(XSSFilter.class);

  private boolean containsJS(String value) {

    boolean foundXSS = false;
    if (value == null || value.isEmpty()) {
      return false;
    }
    Pattern scriptPattern = Pattern.compile(
        "(?i)<[\\s]*/?script.*?>|<[\\s]*/?embed.*?>|<[\\s]*/?object.*?>|<[\\s]*a[\\s]*href[^>]*javascript[\\s]*:[^(^)^>]*[(][^)]*[)][^>]*>[^<]*(<[\\s]*/[\\s]*a[^>]*>)*",
        Pattern.CASE_INSENSITIVE);
    Matcher scriptMat = scriptPattern.matcher(value);
    if (scriptMat.find()) {
      foundXSS = true;
    }
    return foundXSS;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    boolean foundXSS = false;

    Enumeration<String> params = request.getParameterNames();
    while (params.hasMoreElements()) {
      String param = params.nextElement();
      String value = request.getParameter(param);

      if (foundXSS) {

        break;
      }
      foundXSS = containsJS(value);
    }

    if (!foundXSS) {
      chain.doFilter(request, response);
    } else {
      LOGGER.warn("found out xss request");
      return;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void destroy() {
	  LOGGER.debug("destroy nothing in XSSFilter destroy method");

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
	  LOGGER.debug("init nothing in XSSFilter init method");

  }
}

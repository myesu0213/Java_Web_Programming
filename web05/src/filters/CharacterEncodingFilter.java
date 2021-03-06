package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {
	FilterConfig config;
	
	@Override
	public void destroy() {
	
	}
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain nextFilter)
			throws IOException, ServletException {
		//서블릿을 실행하기 전에 수행할 작업
		request.setCharacterEncoding("UTF-8");
		
		nextFilter.doFilter(request, response); //이 구문 호출 안 하면 다음으로 못 감
		
		//서블릿을 실행한 후 수행할 작업
				
		
	}

}

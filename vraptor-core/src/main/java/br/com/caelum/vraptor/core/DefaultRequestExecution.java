package br.com.caelum.vraptor.core;

import java.io.IOException;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.interceptor.ExecuteMethodInterceptor;
import br.com.caelum.vraptor.interceptor.InstantiateInterceptor;
import br.com.caelum.vraptor.interceptor.ResourceLookupInterceptor;

/**
 * A request execution process.
 * 
 * @author Guilherme Silveira
 */
public class DefaultRequestExecution implements RequestExecution {
    private final InterceptorStack interceptorStack;
    private final InstantiateInterceptor instantiateInterceptor;

    public DefaultRequestExecution(InterceptorStack interceptorStack, InstantiateInterceptor instantiateInterceptor) {
        this.interceptorStack = interceptorStack;
        this.instantiateInterceptor = instantiateInterceptor;
    }

    public void execute() throws IOException, InterceptionException {
        interceptorStack.add(ResourceLookupInterceptor.class);
        interceptorStack.add(instantiateInterceptor);
        interceptorStack.add(ExecuteMethodInterceptor.class);
        interceptorStack.next(null, null);
    }
}

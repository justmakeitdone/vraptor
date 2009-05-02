/***
 * 
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer. 2. Redistributions in
 * binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other
 * materials provided with the distribution. 3. Neither the name of the
 * copyright holders nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written
 * permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package br.com.caelum.vraptor.converter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.ResourceBundle;

import org.junit.Before;
import org.junit.Test;

public class PrimitiveFloatConverterTest {

	private PrimitiveFloatConverter converter;
	private ResourceBundle bundle;

	@Before
	public void setup() {
		this.converter = new PrimitiveFloatConverter();
		this.bundle = ResourceBundle.getBundle("messages");
	}

	@Test
	public void shouldBeAbleToConvertNumbers() {
		assertThat((Float) converter.convert("2.2", float.class, bundle), is(equalTo(2.2f)));
	}

	@Test
	public void shouldComplainAboutInvalidNumber() {
		try {
			converter.convert("---", float.class, bundle);
		} catch (ConversionError e) {
			assertThat(e.getMessage(), is(equalTo("--- is not a valid number.")));
		}
	}

	@Test
	public void shouldConvertToZeroWhenNull() {
		assertThat((Float) converter.convert(null, float.class, bundle), is(equalTo(0F)));
	}

	@Test
	public void shouldConvertToZeroWhenEmpty() {
		assertThat((Float) converter.convert("", float.class, bundle), is(equalTo(0F)));
	}

}

/*
 * Copyright 2011 napile
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.napile.cpp4idea.lang.parser.firstparsing;

import org.napile.cpp4idea.lang.lexer.CTokenType;
import com.intellij.lang.PsiBuilder;

/**
 * @author VISTALL
 * @date 15:14/16.12.2011
 */
public class FirstParsing implements CTokenType
{
	public static void parse(PsiBuilder builder)
	{
		if(builder.getTokenType() == S_INCLUDE_KEYWORD)
			SharpIncludeKeyword.parse(builder);
		else if(builder.getTokenType() == S_DEFINE_KEYWORD)
			SharpDefineKeyword.parse(builder);
		else if(builder.getTokenType() == S_IFNDEF_KEYWORD || builder.getTokenType() == S_IFDEF_KEYWORD)
			SharpIfdefKeyword.parseIf(builder);
		else
			builder.advanceLexer();
	}
}
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

package org.napile.cpp4idea.ide.highlight;

import java.util.HashMap;
import java.util.Map;

import org.jetbrains.annotations.NotNull;
import org.napile.cpp4idea.lang.lexer.CFlexLexer;
import org.napile.cpp4idea.lang.lexer.CTokenType;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.SyntaxHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.JavaTokenType;
import com.intellij.psi.tree.IElementType;

/**
 * @author VISTALL
 * @date 20:08/15.12.2011
 */
public class CBaseSyntaxHighlighter extends SyntaxHighlighterBase
{
	private static final Map<IElementType, TextAttributesKey> ATTRIBUTES = new HashMap<IElementType, TextAttributesKey>();

	static
	{
		ATTRIBUTES.put(CTokenType.LPARENTH, SyntaxHighlighterColors.PARENTHS);
		ATTRIBUTES.put(CTokenType.RPARENTH, SyntaxHighlighterColors.PARENTHS);

		ATTRIBUTES.put(CTokenType.LBRACE, SyntaxHighlighterColors.BRACES);
		ATTRIBUTES.put(CTokenType.RBRACE, SyntaxHighlighterColors.BRACES);

		ATTRIBUTES.put(CTokenType.LBRACKET, SyntaxHighlighterColors.BRACKETS);
		ATTRIBUTES.put(CTokenType.RBRACKET, SyntaxHighlighterColors.BRACKETS);

		ATTRIBUTES.put(CTokenType.COMMA, CSyntaxHighlighter.COMMA);
		ATTRIBUTES.put(CTokenType.DOT, CSyntaxHighlighter.DOT);
		ATTRIBUTES.put(JavaTokenType.SEMICOLON, SyntaxHighlighterColors.JAVA_SEMICOLON);

		ATTRIBUTES.put(CTokenType.C_STYLE_COMMENT, CSyntaxHighlighter.BLOCK_COMMENT);
		ATTRIBUTES.put(CTokenType.END_OF_LINE_COMMENT, CSyntaxHighlighter.LINE_COMMENT);
		ATTRIBUTES.put(CTokenType.BAD_CHARACTER, HighlighterColors.BAD_CHARACTER);

		/*ATTRIBUTES.put(CTokenType.INTEGER_LITERAL, CSyntaxHighlighter.NUMBER);
		ATTRIBUTES.put(CTokenType.LONG_LITERAL, CSyntaxHighlighter.NUMBER);
		ATTRIBUTES.put(CTokenType.FLOAT_LITERAL, CSyntaxHighlighter.NUMBER);
		ATTRIBUTES.put(CTokenType.DOUBLE_LITERAL, CSyntaxHighlighter.NUMBER);  */

		fillMap(ATTRIBUTES, CTokenType.OPERATION_SET, SyntaxHighlighterColors.OPERATION_SIGN);
	}

	@NotNull
	@Override
	public Lexer getHighlightingLexer()
	{
		return new CFlexLexer();
	}

	@NotNull
	@Override
	public TextAttributesKey[] getTokenHighlights(IElementType tokenType)
	{
		return pack(ATTRIBUTES.get(tokenType));
	}
}

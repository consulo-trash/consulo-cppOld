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
 *    limitations under the License.
 */

package org.napile.cpp4idea.lang.psi.visitors;

import org.napile.cpp4idea.lang.psi.CPsiCompilerVariable;
import org.napile.cpp4idea.lang.psi.CPsiDefine;
import org.napile.cpp4idea.lang.psi.CPsiElement;
import org.napile.cpp4idea.lang.psi.CPsiFile;
import org.napile.cpp4idea.lang.psi.CPsiIfDefHolder;
import org.napile.cpp4idea.lang.psi.CPsiIfNotDefHolder;
import org.napile.cpp4idea.lang.psi.CPsiInclude;
import org.napile.cpp4idea.lang.psi.CPsiIndependInclude;

/**
 * @author VISTALL
 * @date 17:36/11.12.2011
 */
public class CPsiVisitor
{
	public void visitElement(CPsiElement element)
	{
	}

	public void visitFile(CPsiFile file)
	{
		visitElement(file);
	}

	public void visitDefine(CPsiDefine define)
	{
		visitElement(define);
	}

	public void visitInclude(CPsiInclude include)
	{
		visitElement(include);
	}

	public void visitIndependInclude(CPsiIndependInclude include)
	{
		visitElement(include);
	}

	public void visitIfDefHolder(CPsiIfDefHolder element)
	{
		visitElement(element);
	}

	public void visitIfNotDefHolder(CPsiIfNotDefHolder element)
	{
		visitElement(element);
	}

	public void visitCompilerVariable(CPsiCompilerVariable element)
	{
		visitElement(element);
	}
}
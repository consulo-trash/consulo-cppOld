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

package org.napile.cpp4idea.lang.psi.impl;

import org.jetbrains.annotations.NotNull;
import org.napile.cpp4idea.CFileType;
import org.napile.cpp4idea.CLanguage;
import org.napile.cpp4idea.lang.psi.CPsiGenFile;
import org.napile.cpp4idea.lang.psi.CPsiRawFile;
import org.napile.cpp4idea.lang.psi.visitors.CPsiElementVisitor;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElementVisitor;

/**
 * @author VISTALL
 * @date 16:34/15.12.2011
 */
public class CPsiGenFileImpl extends PsiFileBase implements CPsiGenFile
{
	private CPsiRawFile _rawFile;

	public CPsiGenFileImpl(@NotNull CPsiRawFile rawFile, @NotNull FileViewProvider viewProvider)
	{
		super(viewProvider, CLanguage.INSTANCE);

		_rawFile = rawFile;
	}

	@Override
	public void accept(@NotNull PsiElementVisitor visitor)
	{
		if(visitor instanceof CPsiElementVisitor)
			((CPsiElementVisitor)visitor).visitGenFile(this);
		else
			throw new IllegalArgumentException();
	}

	@NotNull
	@Override
	public FileType getFileType()
	{
		return CFileType.INSTANCE;
	}

	@Override
	public CPsiRawFile getRawFile()
	{
		return _rawFile;
	}
}

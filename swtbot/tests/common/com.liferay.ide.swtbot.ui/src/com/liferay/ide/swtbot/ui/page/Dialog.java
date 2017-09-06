/*******************************************************************************
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 *******************************************************************************/

package com.liferay.ide.swtbot.ui.page;

import com.liferay.ide.swtbot.ui.util.StringPool;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;

/**
 * @author Terry Jia
 * @author Ashley Yuan
 */
public class Dialog extends CancelableShell
{

    private String confirmBtnLabel = OK;

    public Dialog( final SWTWorkbenchBot bot )
    {
        super( bot );
    }

    public Dialog( final SWTWorkbenchBot bot, final String title )
    {
        super( bot, title );
    }

    public Dialog( final SWTWorkbenchBot bot, final String cancelBtnLabel, final String confirmBtnLabel )
    {
        this( bot, StringPool.BLANK, cancelBtnLabel, confirmBtnLabel );
    }

    public Dialog(
        final SWTWorkbenchBot bot, final String title, final String cancelBtnLabel, final String confirmBtnLabel )
    {
        super( bot, title, cancelBtnLabel );

        this.confirmBtnLabel = confirmBtnLabel;
    }

    public void confirm()
    {
        clickBtn( confirmBtn() );
    }

    public Button confirmBtn()
    {
        return new Button( bot, confirmBtnLabel );
    }

}

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

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;

/**
 * @author Terry Jia
 * @author Ashley Yuan
 */
public class Wizard extends CancelableShell
{

    private String backBtnLabel = BACK_WITH_LEFT_BRACKET;
    private String finishBtnLabel = FINISH;
    private String nextBtnLabel = NEXT_WITH_BRACKET;

    private int validationMsgIndex = -1;

    public Wizard( final SWTWorkbenchBot bot )
    {
        super( bot );
    }

    public Wizard( final SWTWorkbenchBot bot, final String title )
    {
        super( bot, title );
    }

    public Wizard( final SWTWorkbenchBot bot, final int validationMsgIndex )
    {
        super( bot );

        this.validationMsgIndex = validationMsgIndex;
    }

    public Wizard( final SWTWorkbenchBot bot, final String title, final int validationMsgIndex )
    {
        super( bot, title );

        this.validationMsgIndex = validationMsgIndex;
    }

    public Wizard(
        final SWTWorkbenchBot bot, final String title, final String cancelBtnLabel, final String finishBtnLabel,
        final String backBtnLabel, final String nextButtonText )
    {
        super( bot, title, cancelBtnLabel );

        this.finishBtnLabel = finishBtnLabel;

        this.backBtnLabel = backBtnLabel;

        this.nextBtnLabel = nextButtonText;
    }

    public Wizard(
        final SWTWorkbenchBot bot, final String title, final String cancelBtnLabel, final String finishBtnLabel,
        final String backBtnLabel, final String nextBtnLabel, final int validationMsgIndex )
    {
        super( bot, title, cancelBtnLabel );

        this.finishBtnLabel = finishBtnLabel;

        this.backBtnLabel = backBtnLabel;

        this.nextBtnLabel = nextBtnLabel;

        this.validationMsgIndex = validationMsgIndex;
    }

    public void back()
    {
        clickBtn( backBtn() );
    }

    public Button backBtn()
    {
        return new Button( bot, backBtnLabel );
    }

    public void finish()
    {
        clickBtn( finishBtn() );

        sleep();
    }

    public Button finishBtn()
    {
        return new Button( bot, finishBtnLabel );
    }

    public String getValidationMsg( final int validationMsgIndex )
    {
        if( validationMsgIndex < 0 )
        {
            log.error( "Validation Msg Index error" );

            return null;
        }

        sleep();

        return bot.text( validationMsgIndex ).getText().trim();
    }

    public String getValidationMsg()
    {
        return getValidationMsg( validationMsgIndex );
    }

    public void next()
    {
        clickBtn( nextBtn() );
    }

    public Button nextBtn()
    {
        return new Button( bot, nextBtnLabel );
    }

}

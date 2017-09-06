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
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;

/**
 * @author Terry Jia
 * @author Ashley Yuan
 */
public class Text extends AbstractWidget
{

    public Text( final SWTWorkbenchBot bot )
    {
        super( bot );
    }

    public Text( final SWTWorkbenchBot bot, final int index )
    {
        super( bot, index );
    }

    public Text( final SWTWorkbenchBot bot, final String label )
    {
        super( bot, label );
    }

    public Text( final SWTWorkbenchBot bot, final String label, final int index )
    {
        super( bot, label, index );
    }

    @Override
    protected SWTBotText getWidget()
    {
        if( !isLabelNull() && hasIndex() )
        {
            return bot.text( label, index );
        }
        else if( isLabelNull() && hasIndex() )
        {
            return bot.text( index );
        }
        else if( !isLabelNull() && !hasIndex() )
        {
            return bot.textWithLabel( label );
        }
        else
        {
            return bot.text();
        }
    }

    public void setText( final String text )
    {
        getWidget().setText( text );
    }

}

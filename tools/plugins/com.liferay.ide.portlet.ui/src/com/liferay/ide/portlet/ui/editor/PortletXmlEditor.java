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
 * Contributors:
 *      Kamesh Sampath - initial implementation
 *      Gregory Amerson - initial implementation review and ongoing maintenance
 *******************************************************************************/

package com.liferay.ide.portlet.ui.editor;

import com.liferay.ide.portlet.core.model.PortletApp;

import org.eclipse.sapphire.ui.def.DefinitionLoader;
import org.eclipse.sapphire.ui.forms.swt.MasterDetailsEditorPage;
import org.eclipse.sapphire.ui.swt.xml.editor.SapphireEditorForXml;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.IFormPage;

/**
 * @author Kamesh Sampath
 * @author Gregory Amerson
 */
public class PortletXmlEditor extends SapphireEditorForXml
{
    public static final String ID = "com.liferay.ide.eclipse.portlet.ui.editor.PortletXmlEditor"; //$NON-NLS-1$

    public PortletXmlEditor()
    {
        super( PortletApp.TYPE, DefinitionLoader.sdef( PortletXmlEditor.class ).page( "portlet-app.editor" ) );
    }

    public int addPage( final IEditorPart page, final IEditorInput input ) throws PartInitException
    {
        int index = super.addPage( page, input );
        setPageText( index, page.getTitle() );

        return index;
    }

    public void addPage( int index, IFormPage page ) throws PartInitException
    {
        if( page instanceof MasterDetailsEditorPage )
        {
            super.addPage( 1, page.getPartControl() );
            configurePage( 1, page );
        }
    }
}

/* *****************************************************************************
 * Copyright (c) 2006, 2008-2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ola Spjuth - core API and implementation
 *******************************************************************************/
package net.bioclipse.ui.importWizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

public class FileImportWizard extends Wizard implements IImportWizard {
    
    FileImportWizardPage mainPage;

    public FileImportWizard() {
        super();
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.wizard.Wizard#performFinish()
     */
    public boolean performFinish() {
        IFile file = mainPage.createNewFile();
        if (file == null)
            return false;
        return true;
    }
     
    /* (non-Javadoc)
     * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
     */
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        setWindowTitle("File Import Wizard"); //NON-NLS-1
        setNeedsProgressMonitor(true);
        mainPage = new FileImportWizardPage("Import File",selection); //NON-NLS-1
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.wizard.IWizard#addPages()
     */
    public void addPages() {
        super.addPages(); 
        addPage(mainPage);        
    }

}

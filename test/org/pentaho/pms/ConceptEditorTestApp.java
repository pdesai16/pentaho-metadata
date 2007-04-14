package org.pentaho.pms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.pentaho.pms.schema.concept.Concept;
import org.pentaho.pms.schema.concept.DefaultPropertyID;
import org.pentaho.pms.schema.concept.editor.ConceptModel;
import org.pentaho.pms.schema.concept.editor.PropertyManagementWidget;
import org.pentaho.pms.schema.concept.types.string.ConceptPropertyString;

public class ConceptEditorTestApp extends ApplicationWindow {

  // ~ Static fields/initializers ======================================================================================

  private static final Log logger = LogFactory.getLog(ConceptEditorTestApp.class);

  // ~ Instance fields =================================================================================================

  // ~ Constructors ====================================================================================================

  public ConceptEditorTestApp() {
    super(null);
  }

  // ~ Methods =========================================================================================================

  public void run() {
    setBlockOnOpen(true);
    open();
    Display.getCurrent().dispose();
  }

  protected Point getInitialSize() {
    return new Point(500, 500);
  }

  protected Control createContents(final Composite parent) {
    ConceptModel c = new ConceptModel(new Concept());
    c.setProperty(new ConceptPropertyString(DefaultPropertyID.NAME.getId(), "mofongo"));
    c.setProperty(new ConceptPropertyString(DefaultPropertyID.DESCRIPTION.getId(), "pollo"));
    return new PropertyManagementWidget(parent, SWT.NONE, c);
  }

  public static void main(final String[] args) {
    new ConceptEditorTestApp().run();
  }
}

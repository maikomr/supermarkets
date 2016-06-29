package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraphPanelMouseListener implements MouseListener {

	private MainController ctrl;

	public GraphPanelMouseListener(MainController ctrl) {
		this.ctrl = ctrl;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch (ctrl.getCurrentAction()) {
		case NEW_NODE:
			ctrl.createNewNodeActionPerformed(e.getPoint());
			ctrl.setCurrentAction(Action.NONE);
			break;
		case NEW_EDGE:
			System.out.println(ctrl.getClickCount());
			if (ctrl.getClickCount() == 1) {
				ctrl.setSecondEndPoint(e.getPoint());
				ctrl.createNewEdgeActionPerformed();
				ctrl.setClickCount(0);
				ctrl.setCurrentAction(Action.NONE);
			} else {
				ctrl.setFirstEndPoint(e.getPoint());
				ctrl.setClickCount(ctrl.getClickCount() + 1);
			}
			break;
		case SET_LOCATION:
			ctrl.setSource(e.getPoint());
			ctrl.setCurrentAction(Action.NONE);
			break;
		case SET_TARGET:
			ctrl.setTarget(e.getPoint());
			ctrl.setCurrentAction(Action.NONE);
		default:
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}

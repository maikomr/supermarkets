package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Node2D;

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
		default:
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

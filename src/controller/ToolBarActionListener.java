package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ToolBarActionListener implements ActionListener {

	private MainController ctrl;

	public ToolBarActionListener(MainController ctrl) {
		this.ctrl = ctrl;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton button = (JButton) event.getSource();
		ctrl.setClickCount(0);
		switch (button.getName()) {
		case "newNodeBtn":
			ctrl.setCurrentAction(Action.NEW_NODE);
			break;
		case "newEdgeBtn":
			ctrl.setCurrentAction(Action.NEW_EDGE);
			break;
		case "setLocationBtn":
			ctrl.setCurrentAction(Action.SET_LOCATION);
			break;
		case "setTargetBtn":
			ctrl.setCurrentAction(Action.SET_TARGET);
			break;
		case "searchBtn":
			ctrl.search();
			break;
		default:
			break;
		}
	}

}

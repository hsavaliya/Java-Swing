package GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class FormPanel extends JPanel implements ActionListener {
	
	
	
	
	private JTextField txtFName;
	private JTextField txtLName;
	private JTextField txtUName ;
	private JPasswordField txtPassword;
	private JTextField txtTaxID;
	private JCheckBox ischkUSCitizen;
	private JComboBox<String> occupation;
	private JRadioButton femaleRadio;
	private JRadioButton maleRadio;
	private ButtonGroup genderGroup;
	private JList<AgeCategory> ageList;
	private JButton btnAdd;
	private JButton btnCancel;
	
	
	//Interfaces
	private IFormListener formListener;
	
	public FormPanel()
	{
		txtFName = new JTextField(10);
		txtLName = new JTextField(10);
		txtUName = new JTextField(10);
		txtPassword = new JPasswordField(10);
		txtPassword.setEchoChar('*');
		
		
		occupation = new JComboBox<String>();
		//occupation.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>();
		comboModel.addElement("Employee");
		comboModel.addElement("UnEmployee");
		comboModel.addElement("Self Employee");
		comboModel.addElement("Student");
		occupation.setModel(comboModel);
		
		txtTaxID = new JTextField(10);
		txtTaxID.setEditable(false);
		
		ischkUSCitizen = new JCheckBox();
		ischkUSCitizen.setSelected(false);
		ischkUSCitizen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtTaxID.setEditable(ischkUSCitizen.isSelected());
				
			}
		});
		
		
	
		femaleRadio = new JRadioButton("Female");
		femaleRadio.setActionCommand("female");
		femaleRadio.setSelected(true);
		
		maleRadio = new JRadioButton("Male");
		maleRadio.setActionCommand("male");
		
		genderGroup = new ButtonGroup();
		genderGroup.add(femaleRadio);
		genderGroup.add(maleRadio);
		
		
		ageList = new JList<AgeCategory>();
		ageList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultListModel<AgeCategory> model = new DefaultListModel<AgeCategory>();
		model.addElement(new AgeCategory(0, "Under 18"));
		model.addElement(new AgeCategory(1, "18 to 65"));
		model.addElement(new AgeCategory(0, "65 or above"));
		ageList.setModel(model);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		/*
		Dimension dim = getPreferredSize();
		dim.height=500;
		setPreferredSize(dim);
		*/
		setPanelLayout();
		setBorder(BorderFactory.createTitledBorder("Enter Details:"));
	}
	private void setPanelLayout(){
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		//// 1st Row ////
		gc.gridx=0; gc.gridy=0;
		gc.weightx=1;gc.weighty=1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 15);
		add(new JLabel("FirstName:"),gc);
		
		gc.gridx=1; gc.gridy=0;
		gc.weightx=1; gc.weighty=1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 15);
		add(txtFName,gc);
		
		//// 2nd Row ////
		gc.gridx=0; gc.gridy++;
		gc.weightx=1; gc.weighty=1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 15);
		add(new JLabel("LastName:"),gc);
		
		gc.gridx=1; 
		gc.weightx=1; gc.weighty=0.1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 15);
		add(txtLName,gc);
		
		//// 3rd Row ////
		gc.gridx=0; gc.gridy++;
		gc.weightx=1; gc.weighty=1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 15);
		add(new JLabel("UserName:"),gc);
		
		gc.gridx=1; 
		gc.weightx=1; gc.weighty=0.1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 15);
		add(txtUName,gc);
		
		//// 4th Row ////
		gc.gridx=0; gc.gridy++;
		gc.weightx=1; gc.weighty=0.1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 15);
		add(new JLabel("Password:"),gc);
		
		gc.gridx=1; 
		gc.weightx=1; gc.weighty=0.1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 15);
		add(txtPassword,gc);
		
		//// 5th Row ////
		gc.gridx=0; gc.gridy++;
		gc.weightx=1; gc.weighty=0.1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 15);
		add(new JLabel("Occupation:"),gc);
		
		gc.gridx=1; 
		gc.weightx=1; gc.weighty=0.1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 15);
		add(occupation,gc);
		
		
		//// 6th Row ////
		gc.gridx=0; gc.gridy++;
		gc.weightx=1; gc.weighty=0.1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 15);
		add(new JLabel("US Citizen?:"),gc);
		
		gc.gridx=1; 
		gc.weightx=1; gc.weighty=0.1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 15);
		add(ischkUSCitizen,gc);
		
		//// 7th Row ////
		gc.gridx=0; gc.gridy++;
		gc.weightx=1; gc.weighty=0.1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 15);
		add(new JLabel("Tax ID:"),gc);
		
		gc.gridx=1; 
		gc.weightx=1; gc.weighty=0.1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 15);
		add(txtTaxID,gc);
		
		//// 8th Row ////
		gc.gridx=0; gc.gridy++;
		gc.weightx=1; gc.weighty=0.1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 15);
		add(new JLabel("Gender:"),gc);
		
		gc.gridx=1; 
		gc.weightx=1; gc.weighty=0.1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 15);
		add(femaleRadio,gc);
		
		//// 9th Row ////
		gc.gridx=0; gc.gridy++;
		gc.gridx=1; 
		gc.weightx=1; gc.weighty=0.1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 15);
		add(maleRadio,gc);
			
		//// 8th Row ////
		gc.gridx=0; gc.gridy++;
		gc.weightx=1; gc.weighty=0.1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 15);
		add(new JLabel("Age:"),gc);
		
		gc.gridx=1; 
		gc.weightx=1; gc.weighty=0.1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 15);
		add(ageList,gc);
		
		
		//// 9th Row ////
		gc.gridx=0; gc.gridy++;
		gc.weightx=1; gc.weighty=0.1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 15);
		add(btnAdd,gc);
		
		gc.gridx=1; 
		gc.weightx=1; gc.weighty=0.1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 15);
		add(btnCancel,gc);
		

	}
	
	public void setFormActionListener(IFormListener formListener)
	{
		this.formListener = formListener;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton eventBtn = (JButton) e.getSource();
		
		if(eventBtn == btnAdd)
		{
			if(formListener!=null)
			{
				String fName = txtFName.getText();
				String lName = txtLName.getText();
				String uName = txtUName.getText();
				String password = new String(txtPassword.getPassword());
				String occupation1 = (String) occupation.getSelectedItem();
				Boolean isUsCitizen = ischkUSCitizen.isSelected();
				String taxId = txtTaxID.getText();
				String gender = genderGroup.getSelection().getActionCommand();
				int ageCategory = ageList.getSelectedValue().getValue();
				
				//System.out.println("Selected Gender is:" + gender);
				FormEvent formEvent = new FormEvent(fName, lName,uName, password, occupation1, isUsCitizen, taxId,gender,ageCategory);
				
				formListener.FormEventOccured(formEvent);
			}
		}
		else if(eventBtn == btnCancel)
		{
			
		}
	}
}

class AgeCategory{
	
	int value;
	String text;
	public AgeCategory(int value, String text){
		this.value=value;
		this.text=text;
	}
	public String toString()
	{
		return text;
	}
	public int getValue() {
		return value;
	}
}
/*
 * Can create this class if we need value-text pair for Employment.
 */
/*
class EmploymentCategory{
	
	int value;
	String text;
	public EmploymentCategory(int value, String text){
		this.value=value;
		this.text=text;
	}
	public String toString()
	{
		return text;
	}
	public int getValue() {
		return value;
	}
	
	
}
*/


package br.edu.ufrn.controllers;

import br.edu.ufrn.models.Client;
import br.edu.ufrn.models.Employee;
import br.edu.ufrn.models.Inventory;
import br.edu.ufrn.models.Manufacturer;
import br.edu.ufrn.models.Medication;
import br.edu.ufrn.models.Prescription;
import br.edu.ufrn.models.Product;
import br.edu.ufrn.models.Supplier;
import br.edu.ufrn.services.ManufacturerService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {

    //caixa
    @FXML
    private TextField productCodeField;

    @FXML
    private TextField quantityField;

    @FXML
    private Label valueLabel;

    @FXML
    private Label changeLabel;

    @FXML
    private TextField moneyInputField;

    @FXML
    private TableView<Product> caixaTable;

    @FXML
    private TableColumn<Product, String> caixaCodeColumn;

    @FXML
    private TableColumn<Product, String> caixaNameColumn;

    @FXML
    private TableColumn<Product, Integer> caixaQuantityColumn;

    @FXML
    private TableColumn<Product, Double> caixaPriceColumn;

    @FXML
    private TableColumn<Product, Double> caixaTotalPriceColumn;

    @FXML
    private ComboBox<String> caixaClientComboBox;

    @FXML
    private void handleMoneyInput(ActionEvent event) {
        try {
            double receivedMoney = Double.parseDouble(moneyInputField.getText());
            double totalValue = calculateTotalValue();

            if (receivedMoney >= totalValue) {
                double change = receivedMoney - totalValue;
                changeLabel.setText(String.format("R$%.2f", change));
            } else {
                changeLabel.setText("Dinheiro insuficiente!");
            }
        } catch (NumberFormatException e) {
            changeLabel.setText("Entrada inválida!");
        }
    }

    @FXML
    private void handleCompletePurchase(ActionEvent event) {
        System.out.println("Compra finalizada com sucesso!");
        clearForm();
    }

    private void clearForm() {
        productCodeField.clear();
        quantityField.clear();
        moneyInputField.clear();
        valueLabel.setText("R$0.00");
        changeLabel.setText("R$0.00");
        cartData.clear();
        clientNameField.clear();
        clientCpfField.clear();
    }

    private double calculateTotalValue() {
        return 1;
    }

    public void addProductToCart(String code, String name, int quantity, double price) {
        double totalPrice = quantity * price;
        
    }

    private void updateTotalValue() {
        double totalValue = calculateTotalValue();
        valueLabel.setText(String.format("R$%.2f", totalValue));
    }

    private final ObservableList<Product> cartData = FXCollections.observableArrayList();

    private double totalValue = 0.0;
    
    //prescription
    @FXML
    private TextField doctorNameField;

    @FXML
    private DatePicker prescriptionExpirationDatePicker;

    @FXML
    private TableView<Prescription> prescriptionTable;

    @FXML
    private TableColumn<Prescription, Integer> prescriptionIdColumn;

    @FXML
    private TableColumn<Prescription, String> doctorNameColumn;

    @FXML
    private TableColumn<Prescription, String> prescriptionExpirationDateColumn;

    private final ObservableList<Prescription> prescriptionData = FXCollections.observableArrayList();

    private void loadPrescriptionData() {
    }

    @FXML
    private void handleAddPrescription(ActionEvent event) {
    }

    @FXML
    private void handleEditPrescription(ActionEvent event) {
    }

    @FXML
    private void handleRemovePrescription(ActionEvent event) {
    }

    @FXML
    private void clearPrescriptionForm() {
        doctorNameField.clear();
        prescriptionExpirationDatePicker.setValue(null);
        System.out.println("Formulário de receitas médicas limpo.");
    }

    //employee
    @FXML
    private TextField employeeNameField;

    @FXML
    private TextField employeeCpfField;

    @FXML
    private TextField employeePhoneField;

    @FXML
    private TextField employeeAddressField;

    @FXML
    private TextField employeeRoleField;

    @FXML
    private TextField employeeUsernameField;

    @FXML
    private PasswordField employeePasswordField;

    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private TableColumn<Employee, String> employeeNameColumn;

    @FXML
    private TableColumn<Employee, String> employeeCpfColumn;

    @FXML
    private TableColumn<Employee, String> employeePhoneColumn;

    @FXML
    private TableColumn<Employee, String> employeeAddressColumn;

    @FXML
    private TableColumn<Employee, String> employeeRoleColumn;

    @FXML
    private TableColumn<Employee, String> employeeUsernameColumn;

    private final ObservableList<Employee> employeeData = FXCollections.observableArrayList();

    private void loadEmployeeData() {
    }

    @FXML
    private void handleAddEmployee(ActionEvent event) {

    }

    @FXML
    private void handleEditEmployee(ActionEvent event) {
        
    }

    @FXML
    private void handleRemoveEmployee(ActionEvent event) {

    }

    @FXML
    private void clearEmployeeForm() {
        employeeNameField.clear();
        employeeCpfField.clear();
        employeePhoneField.clear();
        employeeAddressField.clear();
        employeeRoleField.clear();
        employeeUsernameField.clear();
        employeePasswordField.clear();
        System.out.println("Formulário de empregados limpo.");
    }

    //client
    @FXML
    private TextField clientIdField;

    @FXML
    private TextField clientNameField;

    @FXML
    private TextField clientCpfField;

    @FXML
    private TextField clientPhoneField;

    @FXML
    private TextField clientAddressField;

    @FXML
    private TableView<Client> clientTable;

    @FXML
    private TableColumn<Client, Integer> clientIdColumn;

    @FXML
    private TableColumn<Client, String> clientNameColumn;

    @FXML
    private TableColumn<Client, String> clientCpfColumn;

    @FXML
    private TableColumn<Client, String> clientPhoneColumn;

    @FXML
    private TableColumn<Client, String> clientAddressColumn;

    private final ObservableList<Client> clientData = FXCollections.observableArrayList();

    private void loadClientData() {
    }

    @FXML
    private void handleAddClient(ActionEvent event) {
        String name = clientNameField.getText();
        String cpf = clientCpfField.getText();
        String phone = clientPhoneField.getText();
        String address = clientAddressField.getText();

        if (!name.isEmpty() && !cpf.isEmpty() && !phone.isEmpty() && !address.isEmpty()) {
            System.out.println("Cliente cadastrado com sucesso!");
        } else {
            System.out.println("Todos os campos devem ser preenchidos.");
        }
    }

    @FXML
    private void handleEditClient(ActionEvent event) {
    }

    @FXML
    private void handleRemoveClient(ActionEvent event) {
    }

    @FXML
    private void clearClientForm() {
        clientNameField.clear();
        clientCpfField.clear();
        clientPhoneField.clear();
        clientAddressField.clear();
        System.out.println("Formulário de cliente limpo.");
    }

    //inventory
    @FXML
    private TextField inventoryIdField;

    @FXML
    private ComboBox<String> inventoryMedicationComboBox;

    @FXML
    private ComboBox<String> supplierComboBox;

    @FXML
    private TextField inventoryQtyField;

    @FXML
    private TextField inventoryPriceField;

    @FXML
    private TableView<Inventory> inventoryTable;

    @FXML
    private TableColumn<Inventory, String> inventoryMedicationColumn;

    @FXML
    private TableColumn<Inventory, String> inventorySupplierColumn;

    @FXML
    private TableColumn<Inventory, Integer> inventoryQtyColumn;

    @FXML
    private TableColumn<Inventory, Double> inventoryPriceColumn;

    private final ObservableList<Inventory> inventoryData = FXCollections.observableArrayList();

    private void loadInventoryData() {
        System.out.println("Carregando dados de estoque...");
    }

    @FXML
    private void handleAddInventory(ActionEvent event) {
        System.out.println("Estoque cadastrado com sucesso!");
    }

    @FXML
    private void handleEditInventory(ActionEvent event) {
        System.out.println("Estoque editado com sucesso!");
    }

    @FXML
    private void handleRemoveInventory(ActionEvent event) {
        System.out.println("Estoque removido com sucesso!");
    }

    @FXML
    private void clearInventoryForm() {
        supplierComboBox.setValue(null);
        inventoryQtyField.clear();
        inventoryPriceField.clear();
        System.out.println("Formulário de estoque limpo.");
    }

    //manufacturer  
    @FXML
    private TextField manufacturerIdField;

    @FXML
    private TextField manufacturerNameField;

    @FXML
    private TableView<Manufacturer> manufacturerTable;

    @FXML   
    private TableColumn<Manufacturer, String> manufacturerNameColumn;

    private final ObservableList<Manufacturer> manufacturerData = FXCollections.observableArrayList();

    private void loadManufacturerData() {
        
    }

    @FXML
    private void handleAddManufacturer(ActionEvent event) {
        String name = manufacturerNameField.getText();
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(name);
        new ManufacturerService().save(manufacturer);
        System.out.println("Fabricante cadastrado com sucesso!");
    }

    @FXML
    private void handleEditManufacturer(ActionEvent event) {
        System.out.println("Fabricante editado com sucesso!");
    }

    @FXML
    private void handleRemoveManufacturer(ActionEvent event) {
        System.out.println("Fabricante removido com sucesso!");
    }

    @FXML
    private void clearManufacturerForm() {
        manufacturerNameField.clear();
        System.out.println("Formulário de fabricantes limpo.");
    }

    //supplier
    @FXML
    private TextField supplierIdField;

    @FXML
    private TextField supplierNameField;

    @FXML
    private TableView<Supplier> supplierTable;

    @FXML
    private TableColumn<Supplier, String> supplierNameColumn;

    private final ObservableList<Supplier> supplierData = FXCollections.observableArrayList();

    private void loadSupplierData() {
        System.out.println("Carregando dados dos fornecedores...");
    }

    @FXML
    private void handleAddSupplier(ActionEvent event) {
        System.out.println("Fornecedor cadastrado com sucesso!");
    }

    @FXML
    private void handleEditSupplier(ActionEvent event) {
        System.out.println("Fornecedor editado com sucesso!");
    }

    @FXML
    private void handleRemoveSupplier(ActionEvent event) {
        System.out.println("Fornecedor removido com sucesso!");
    }

    @FXML
    private void clearSupplierForm() {
        supplierNameField.clear();
        System.out.println("Formulário de fornecedores limpo.");
    }

    //product
    @FXML
    private TextField productIdField;

    @FXML
    private TextField productNameField;

    @FXML
    private TextField productBottleQtyField;

    @FXML
    private ComboBox<String> unitComboBox;

    @FXML
    private TextField productUnitPriceField;

    @FXML
    private ComboBox<String> prescriptionComboBox;

    @FXML
    private ComboBox<String> medicationComboBox;

    @FXML
    private TableView<Product> productTable;

    @FXML
    private TableColumn<Product, String> productNameColumn;

    @FXML
    private TableColumn<Product, Integer> productBottleQtyColumn;

    @FXML
    private TableColumn<Product, String> productUnitColumn;

    @FXML
    private TableColumn<Product, Double> productUnitPriceColumn;

    @FXML
    private TableColumn<Product, String> productPrescriptionColumn;

    @FXML
    private TableColumn<Product, String> productMedicationColumn;

    private final ObservableList<Product> productData = FXCollections.observableArrayList();

    private void loadProductData() {
        
    }

    @FXML
    private void handleAddProduct(ActionEvent event) {
        System.out.println("Produto cadastrado com sucesso!");
    }

    @FXML
    private void handleEditProduct(ActionEvent event) {
        System.out.println("Produto editado com sucesso!");
    }

    @FXML
    private void handleRemoveProduct(ActionEvent event) {
        System.out.println("Produto removido com sucesso!");
    }

    @FXML
    private void clearProductForm() {
        productNameField.clear();
        productBottleQtyField.clear();
        unitComboBox.setValue(null);
        productUnitPriceField.clear();
        prescriptionComboBox.setValue(null);
        medicationComboBox.setValue(null);
        System.out.println("Formulário de produtos limpo.");
    }

    //medication
    @FXML
    private TextField medicationIdField;

    @FXML
    private TextField medicationNameField;

    @FXML
    private TextField medicationPriceField;

    @FXML
    private DatePicker medicationExpirationDatePicker;

    @FXML
    private ComboBox<String> manufacturerComboBox;

    @FXML
    private TableView<Medication> medicationTable;

    @FXML
    private TableColumn<Medication, String> nameColumn;

    @FXML
    private TableColumn<Medication, Double> priceColumn;

    @FXML
    private TableColumn<Medication, String> expirationDateColumn;

    @FXML
    private TableColumn<Medication, String> manufacturerColumn;

    private final ObservableList<Medication> medicationData = FXCollections.observableArrayList();

    private void loadMedicationData() {
    }

    @FXML
    private void handleAddMedication(ActionEvent event) {
        System.out.println("Medicamento cadastrado com sucesso!");
    }

    @FXML
    private void handleEditMedication(ActionEvent event) {
        System.out.println("Medicamento cadastrado com sucesso!");
    }

    @FXML
    private void handleRemoveMedication(ActionEvent event) {
        System.out.println("Medicamento cadastrado com sucesso!");
    }

    @FXML
    private void clearMedicationForm() {
        medicationNameField.clear();
        medicationPriceField.clear();
        medicationExpirationDatePicker.setValue(null);
        manufacturerComboBox.setValue(null);
        System.out.println("Formulário de medicamentos limpo.");
    }

    //finally
    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        expirationDateColumn.setCellValueFactory(new PropertyValueFactory<>("expirationDate"));
        manufacturerColumn.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        loadMedicationData();
        medicationTable.setItems(medicationData);

        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        productBottleQtyColumn.setCellValueFactory(new PropertyValueFactory<>("bottleQty"));
        productUnitColumn.setCellValueFactory(new PropertyValueFactory<>("unit"));
        productUnitPriceColumn.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        productPrescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("prescription"));
        productMedicationColumn.setCellValueFactory(new PropertyValueFactory<>("medication"));
        unitComboBox.setItems(FXCollections.observableArrayList("Gramas (g)", "Mililitros (ml)", "Comprimidos"));
        unitComboBox.setPromptText("Selecione a unidade");
        loadProductData();
        productTable.setItems(productData);

        supplierNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        loadSupplierData();
        supplierTable.setItems(supplierData);

        manufacturerNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        loadManufacturerData();
        manufacturerTable.setItems(manufacturerData);

        inventoryMedicationColumn.setCellValueFactory(new PropertyValueFactory<>("supplier"));
        inventorySupplierColumn.setCellValueFactory(new PropertyValueFactory<>("supplier"));
        inventoryQtyColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        inventoryPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        supplierComboBox.setItems(FXCollections.observableArrayList("Fornecedor 1", "Fornecedor 2", "Fornecedor 3"));
        supplierComboBox.setPromptText("Selecione o Fornecedor");
        loadInventoryData();
        inventoryTable.setItems(inventoryData);

        clientIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        clientNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        clientCpfColumn.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        clientPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        clientAddressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        loadClientData();
        clientTable.setItems(clientData);

        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        employeeCpfColumn.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        employeePhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        employeeAddressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        employeeRoleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
        employeeUsernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        loadEmployeeData();
        employeeTable.setItems(employeeData);

        prescriptionIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        doctorNameColumn.setCellValueFactory(new PropertyValueFactory<>("doctorName"));
        prescriptionExpirationDateColumn.setCellValueFactory(new PropertyValueFactory<>("expirationDate"));
        loadPrescriptionData();
        prescriptionTable.setItems(prescriptionData);

        caixaCodeColumn.setCellValueFactory(cellData -> 
            new SimpleStringProperty(String.valueOf(cellData.getValue().getId()))
        );
        caixaNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        caixaQuantityColumn.setCellValueFactory(cellData -> cellData.getValue().bottleQtyProperty().asObject());
        caixaPriceColumn.setCellValueFactory(cellData -> cellData.getValue().unitValueProperty().asObject());
        caixaTotalPriceColumn.setCellValueFactory(cellData -> cellData.getValue().totalPriceProperty().asObject());
        productTable.setItems(cartData);
        valueLabel.setText("R$0.00");
        changeLabel.setText("R$0.00");
    }
}


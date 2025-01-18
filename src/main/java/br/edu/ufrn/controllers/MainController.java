package br.edu.ufrn.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.edu.ufrn.models.Client;
import br.edu.ufrn.models.Employee;
import br.edu.ufrn.models.Inventory;
import br.edu.ufrn.models.Manufacturer;
import br.edu.ufrn.models.Medication;
import br.edu.ufrn.models.Prescription;
import br.edu.ufrn.models.Product;
import br.edu.ufrn.models.Supplier;
import br.edu.ufrn.services.ManufacturerService;
import br.edu.ufrn.services.MedicationService;
import br.edu.ufrn.services.SupplierService;
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
    private TableColumn<Manufacturer, Long> manufacturerIdColumn;

    @FXML   
    private TableColumn<Manufacturer, String> manufacturerNameColumn;

    private final ObservableList<Manufacturer> manufacturerData = FXCollections.observableArrayList();

    private void loadManufacturerData() {
        manufacturerData.clear();
        ManufacturerService manufacturerService = new ManufacturerService();
        List<Manufacturer> manufacturers = manufacturerService.getAll();

        if (manufacturers != null) {
            manufacturerData.addAll(manufacturers);
            manufacturerComboBox.setItems(FXCollections.observableArrayList(manufacturerService.getAllNames()));
        }

        manufacturerTable.setItems(manufacturerData);
    }

    @FXML
    private void handleAddManufacturer(ActionEvent event) {
        String name = manufacturerNameField.getText();
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(name);
        new ManufacturerService().save(manufacturer);
        loadManufacturerData();
        clearManufacturerForm();
        System.out.println("Fabricante cadastrado com sucesso!");
    }

    @FXML
    private void handleEditManufacturer(ActionEvent event) {
        try {
            Long id = Long.parseLong(manufacturerIdField.getText());
            String name = manufacturerNameField.getText();
    
            if (id != null && !name.isEmpty()) {
                Manufacturer manufacturer = new Manufacturer();
                manufacturer.setId(id);
                manufacturer.setName(name);
    
                ManufacturerService manufacturerService = new ManufacturerService();
                boolean isUpdated = manufacturerService.update(manufacturer, new String[]{name});
    
                if (isUpdated) {
                    System.out.println("Fabricante atualizado com sucesso!");
                    loadManufacturerData();
                    clearManufacturerForm();
                } else {
                    System.out.println("Erro ao atualizar o fabricante.");
                }
            } else {
                System.out.println("Preencha os campos corretamente.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao editar o fabricante: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    @FXML
    private void handleRemoveManufacturer(ActionEvent event) {
        Long id = Long.parseLong(manufacturerIdField.getText());

        if (id != null) {
            ManufacturerService manufacturerService = new ManufacturerService();
            manufacturerService.delete(id);
            loadManufacturerData();
            clearManufacturerForm();
            System.out.println("Fabricante deletado com sucesso!");
        } else {
            System.out.println("Erro ao deletar o fabricante.");
        }
    }

    @FXML
    private void clearManufacturerForm() {
        manufacturerIdField.clear();
        manufacturerNameField.clear();
        System.out.println("Formulário de fabricantes limpo.");
    }

    //supplier
    @FXML
    private TextField supplierIdField;

    @FXML
    private TextField supplierNameField;

    @FXML
    private TextField filterNameField;

    @FXML
    private TextField filterPriceField;

    @FXML
    private ComboBox<String> filterManufacturerComboBox;

    @FXML
    private TableView<Supplier> supplierTable;

    @FXML
    private TableColumn<Supplier, Long> supplierIdColumn;

    @FXML
    private TableColumn<Supplier, String> supplierNameColumn;

    private final ObservableList<Supplier> supplierData = FXCollections.observableArrayList();

    private void loadSupplierData() {
        supplierData.clear();
        SupplierService supplierService = new SupplierService();
        List<Supplier> suppliers = supplierService.getAll();

        if (suppliers != null) {
            supplierData.addAll(suppliers);
        }

        supplierTable.setItems(supplierData);
    }

    @FXML
    private void handleAddSupplier(ActionEvent event) {
        String name = supplierNameField.getText();
        Supplier supplier = new Supplier();
        supplier.setName(name);
        new SupplierService().save(supplier);
        loadSupplierData();
        clearSupplierForm();
        System.out.println("Fornecedor cadastrado com sucesso!");
    }

    @FXML
    private void handleEditSupplier(ActionEvent event) {
        try {
            Long id = Long.parseLong(supplierIdField.getText());
            String name = supplierNameField.getText();
    
            if (id != null && !name.isEmpty()) {
                Supplier supplier = new Supplier();
                supplier.setId(id);
                supplier.setName(name);
    
                SupplierService supplierService = new SupplierService();
                boolean isUpdated = supplierService.update(supplier, new String[]{name});
    
                if (isUpdated) {
                    System.out.println("Fornecedor atualizado com sucesso!");
                    loadSupplierData();
                    clearSupplierForm();
                } else {
                    System.out.println("Erro ao atualizar o fornecedor.");
                }
            } else {
                System.out.println("Preencha os campos corretamente.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao editar o fornecedor: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Fornecedor editado com sucesso!");
    }

    @SuppressWarnings("unused")
    @FXML
    private void handleRemoveSupplier(ActionEvent event) {
        Long id = Long.parseLong(supplierIdField.getText());

        if (id != null) {
            SupplierService supplierService = new SupplierService();
            supplierService.delete(id);
            loadSupplierData();
            clearSupplierForm();
            System.out.println("Fornecedor deletado com sucesso!");
        } else {
            System.out.println("Erro ao deletar o fornecedor.");
        }
    }

    @FXML
    private void clearSupplierForm() {
        supplierIdField.clear();
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
    private TableColumn<Medication, Long> medicationIdColumn;

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
        medicationData.clear();
        MedicationService medicationService = new MedicationService();
        List<Medication> medications = medicationService.getAll();

        if (medications != null) {
            medicationData.addAll(medications);
        }

        medicationTable.setItems(medicationData);
    }

    @FXML
    private void handleAddMedication(ActionEvent event) {
        String name = medicationNameField.getText();
        Double price = Double.parseDouble(medicationPriceField.getText());
        LocalDate localDate = medicationExpirationDatePicker.getValue();
        Date date = java.sql.Date.valueOf(localDate);
        String selectedManufacturerName = manufacturerComboBox.getValue();
        ManufacturerService manufacturerService = new ManufacturerService();
        Medication medication = new Medication();
        medication.setName(name);
        medication.setPrice(price);
        medication.setExpirationDate(date);
        medication.setManufacturer(manufacturerService.getManufacturerByName(selectedManufacturerName));
        new MedicationService().save(medication);
        loadMedicationData();
        clearMedicationForm();
        System.out.println("Medicamento cadastrado com sucesso!");
    }

    @SuppressWarnings("unused")
    @FXML
    private void handleEditMedication(ActionEvent event) {
        try {
            Long id = Long.parseLong(medicationIdField.getText());
            String name = medicationNameField.getText();
            Double price = Double.parseDouble(medicationPriceField.getText());
            LocalDate localDate = medicationExpirationDatePicker.getValue();
            Date date = java.sql.Date.valueOf(localDate);
            String selectedManufacturerName = manufacturerComboBox.getValue();
            ManufacturerService manufacturerService = new ManufacturerService();
    
            if (id != null) {
                Medication medication = new Medication();
                medication.setId(id);
                medication.setName(name);
                medication.setPrice(price);
                medication.setExpirationDate(date);
                medication.setManufacturer(manufacturerService.getManufacturerByName(selectedManufacturerName));
                MedicationService medicationService = new MedicationService();
                boolean isUpdated = medicationService.update(medication, new String[]{name});
    
                if (isUpdated) {
                    System.out.println("Fornecedor atualizado com sucesso!");
                    loadMedicationData();
                    clearMedicationForm();
                } else {
                    System.out.println("Erro ao atualizar o fornecedor.");
                }
            } else {
                System.out.println("Preencha os campos corretamente.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao editar o fornecedor: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Medicamento cadastrado com sucesso!");
    }

    @SuppressWarnings("unused")
    @FXML
    private void handleRemoveMedication(ActionEvent event) {
        Long id = Long.parseLong(medicationIdField.getText());

        if (id != null) {
            MedicationService medicationService = new MedicationService();
            medicationService.delete(id);
            loadMedicationData();
            clearMedicationForm();
            System.out.println("Fornecedor deletado com sucesso!");
        } else {
            System.out.println("Erro ao deletar o fornecedor.");
        }
        System.out.println("Medicamento cadastrado com sucesso!");
    }

    @FXML
    private void clearMedicationForm() {
        medicationIdField.clear();
        medicationNameField.clear();
        medicationPriceField.clear();
        medicationExpirationDatePicker.setValue(null);
        manufacturerComboBox.setValue(null);
        System.out.println("Formulário de medicamentos limpo.");
    }

    @FXML
    private void clearFilters() {
        filterNameField.clear();
        filterPriceField.clear();
        filterManufacturerComboBox.setValue(null);
        medicationTable.setItems(medicationData); // Volta à lista completa
    }

    @FXML
    private void handleFilterMedications() {
        String nameFilter = filterNameField.getText().toLowerCase();
        String priceFilter = filterPriceField.getText();
        String manufacturerFilter = filterManufacturerComboBox.getValue();

        List<Medication> filteredMedications = medicationData.stream()
            .filter(med -> {
                boolean matchesName = nameFilter.isEmpty() || med.getName().toLowerCase().contains(nameFilter);
                boolean matchesPrice = priceFilter.isEmpty() || med.getPrice() <= Double.parseDouble(priceFilter);
                boolean matchesManufacturer = manufacturerFilter == null || med.getManufacturer().getName().equals(manufacturerFilter);
                return matchesName && matchesPrice && matchesManufacturer;
            })
            .toList();

        medicationTable.setItems(FXCollections.observableArrayList(filteredMedications));
    }

    private void loadManufacturerFilterOptions() {
        ManufacturerService manufacturerService = new ManufacturerService();
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        List<String> manufacturerNames = manufacturers.stream()
            .map(Manufacturer::getName)
            .toList();
    
        filterManufacturerComboBox.setItems(FXCollections.observableArrayList(manufacturerNames));
    }

    //finally
    @FXML
    public void initialize() {
        medicationIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        expirationDateColumn.setCellValueFactory(new PropertyValueFactory<>("expirationDate"));
        manufacturerColumn.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        loadMedicationData();
        loadManufacturerFilterOptions();
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

        supplierIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        supplierNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        loadSupplierData();
        supplierTable.setItems(supplierData);

        manufacturerIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
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


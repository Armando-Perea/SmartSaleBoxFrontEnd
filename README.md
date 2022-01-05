# …or create a new repository on the command line
echo "# JavaMicroService" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M master
git remote add origin https://github.com/Armando-Perea/JavaMicroService.git
git push -u origin master
                

…or push an existing repository from the command line
git remote add origin https://github.com/Armando-Perea/JavaMicroService.git
git branch -M master
git push -u origin master

# LISTO

Agregar un nombre default "SamrtSaleBox"   LISTO
En Administracion, Colocar la opcion para actualizar el nombre del negocio LISTO
Agregar opcion para imprimir Ticket   LISTO
Agregar método para imprimir ticket  LISTO
Antes de mandar a Imprimir, obtener la lista de productos de la tabla de Sales y enviarla como parametro a
SaleTIcket Metod. LISTO


# Pendientes

Imprimir TIcket
Scannear sin textbox
Funciones F9 F12 etc


txtGetProductNameSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (SmartSaleBoxOperations.validateGetProdNameSearch()) {
						ReadProductsInfo.fillProductTableByName(txtGetProductNameSearch.getText());
					} else {
						JOptionPane.showMessageDialog(null, "Ingrese Producto por favor");
					}
				}
			}
		});
		
		
if (e.getKeyCode() == KeyEvent.VK_F9) {
					bulkSaleMain.setVisible(true);
					bulkSaleMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}		
		
		
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("keyTyped " + e.getKeyCode());
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Pressed " + e.getKeyCode());
		if (e.getKeyCode() == KeyEvent.VK_F9) {
            System.out.println("Pressed " + e.getKeyCode());
            bulkSaleMain.setVisible(true);
			bulkSaleMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } 
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("keyReleased " + e.getKeyCode());
		
	}		
		
		
Opcion para envio de mail, ver contraseñas
tab para tarjeta hacia recibido
tab para recibido hacia cobrar

listener para venta por granel	
		
		
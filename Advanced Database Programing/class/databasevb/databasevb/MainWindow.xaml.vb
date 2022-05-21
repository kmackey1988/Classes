Imports System.Data

Public Class MainWindow
	Public Property MydocumentFolder As String

	Private Sub btn1_Click(sender As Object, e As RoutedEventArgs) Handles btn1.Click
		Dim con As New OleDb.OleDbConnection

		Dim dbProvider As String
		Dim dbSource As String
		Dim MydocumentsFolder As String
		Dim TheDatabase As String
		Dim FullDatabasePath As String

		dbProvider = "PROVIDER=Microsoft.ACE.OLEDB.12.0;"

		TheDatabase = “/DocDatabaseTest.accdb”
		MydocumentFolder = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments)
		FullDatabasePath = MydocumentsFolder & TheDatabase

		dbSource = “Data source = “ & FullDatabasePath

		con.ConnectionString = dbProvider & dbSource

		con.Open()
		MessageBox.Show(“Database is now open”)
		con.Close()
		MessageBox.Show(“Database is now closed”)

	End Sub


End Class

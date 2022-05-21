Public Class Form2
    Private Sub Label1_Click(sender As Object, e As EventArgs) Handles Label1.Click

    End Sub

    Private Sub Form2_Load(sender As Object, e As EventArgs) Handles MyBase.Load

    End Sub

    Private Sub ButtonClose_Click(sender As Object, e As EventArgs) Handles ButtonClose.Click

        Application.Exit()


    End Sub

    Private Sub PictureBox1_Click(sender As Object, e As EventArgs) Handles PictureBox1.Click

    End Sub

    Private Sub TextBoxUsername_TextChanged(sender As Object, e As EventArgs) Handles TextBoxUsername.TextChanged

    End Sub

    Private Sub TextBoxPassword_TextChanged(sender As Object, e As EventArgs) Handles TextBoxPassword.TextChanged, TextBoxPassword.Leave, TextBoxPassword.Enter

    End Sub

    Private Sub TextBoxUsername_Enter(sender As Object, e As EventArgs) Handles TextBoxUsername.Enter

        ' clear the textbox when click on it
        Dim username As String = TextBoxUsername.Text
        ' check if the username is empty and if the text box had default values 
        If username.Trim().ToLower() = "username" Or username.Trim() = "" Then

            ' clear the textbox
            TextBoxUsername.Text = ""
            ' change the textbox font color 
            TextBoxUsername.ForeColor = Color.Black

        End If


    End Sub

    Private Sub TextBoxUsername_Leave(sender As Object, e As EventArgs) Handles TextBoxUsername.Leave

        ' clear the textbox when click on it
        Dim username As String = TextBoxUsername.Text
        ' check if the username is empty and if the text box had default values 
        If username.Trim().ToLower() = "username" Or username.Trim() = "" Then

            ' clear the textbox
            TextBoxUsername.Text = "username"
            ' change the textbox font color 
            TextBoxUsername.ForeColor = Color.DarkGray

        End If

    End Sub
    Private Sub TextBoxPassword_Enter(sender As Object, e As EventArgs) Handles TextBoxPassword.Enter

        ' clear the textbox when click on it
        Dim pass As String = TextBoxPassword.Text
        ' check if the username is empty and if the text box had default values 
        If pass.Trim().ToLower() = "password" Or pass.Trim() = "" Then

            ' clear the textbox
            TextBoxPassword.Text = ""
            ' change the textbox font color 
            TextBoxPassword.ForeColor = Color.Black
            'use system password 
            TextBoxPassword.UseSystemPasswordChar = True

        End If


    End Sub

    Private Sub TextBoxPassword_Leave(sender As Object, e As EventArgs) Handles TextBoxPassword.Leave

        ' clear the textbox when clicked off of box
        Dim pass As String = TextBoxPassword.Text
        ' check if the username is empty and if the text box had default values 
        If pass.Trim().ToLower() = "password" Or pass.Trim() = "" Then

            ' set the textbox
            TextBoxPassword.Text = "password"
            ' change the textbox font color 
            TextBoxPassword.ForeColor = Color.DarkGray
            'set system password to fales
            TextBoxPassword.UseSystemPasswordChar = False

        End If

    End Sub


End Class
Public Class Form1
    Private Sub ProgressBar1_Click(sender As Object, e As EventArgs) Handles ProgressBar1.Click

    End Sub

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load

    End Sub

    Private Sub Timer1_Tick(sender As Object, e As EventArgs) Handles Timer1.Tick
        ProgressBar1.Value += 1
        If ProgressBar1.Value <= 10 Then
            Label1.Text = "Loading"

        ElseIf ProgressBar1.Value <= 30 Then
            Label1.Text = "Grab a healthy snack!"

        ElseIf ProgressBar1.Value <= 50 Then
            Label1.Text = "Be Patient"

        ElseIf ProgressBar1.Value <= 70 Then
            Label1.Text = "Welcome!!"

        ElseIf ProgressBar1.Value <= 100 Then
            Label1.Text = "Log That apple!!"

            If ProgressBar1.Value = 100 Then
                Timer1.Dispose()
                Me.Hide()
                Form2.ShowDialog()
                Me.Close()
            End If


        End If

    End Sub
End Class

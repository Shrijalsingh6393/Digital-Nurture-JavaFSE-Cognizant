CREATE PROCEDURE UpdateSalary
  @EmployeeId INT,
  @PercentIncrease FLOAT
AS
BEGIN
    SET NOCOUNT ON;
    BEGIN TRY
        BEGIN TRANSACTION;
        IF NOT EXISTS (SELECT 1 FROM Employees WHERE EmployeeID = @EmployeeId)
        BEGIN
            THROW 50002, 'Employee ID does not exist.', 1;
        END;
        UPDATE Employees
        SET Salary = Salary * (1 + @PercentIncrease / 100.0)
        WHERE EmployeeID = @EmployeeId;
        COMMIT TRANSACTION;
    END TRY
    BEGIN CATCH
        IF XACT_STATE() <> 0
            ROLLBACK TRANSACTION;
        DECLARE @ErrMsg NVARCHAR(4000) = ERROR_MESSAGE();
        INSERT INTO LogErrors (ErrorMessage, ErrorDate) VALUES (@ErrMsg, GETDATE());
        THROW;
    END CATCH
END;

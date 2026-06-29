CREATE PROCEDURE AddNewCustomer
  @CustomerId INT,
  @CustomerName NVARCHAR(100),
  @ContactInfo NVARCHAR(255)
AS
BEGIN
    SET NOCOUNT ON;
    BEGIN TRY
        BEGIN TRANSACTION;
        IF EXISTS (SELECT 1 FROM Customers WHERE CustomerID = @CustomerId)
        BEGIN
            THROW 50003, 'Customer with this ID already exists.', 1;
        END;
        INSERT INTO Customers (CustomerID, CustomerName, ContactInfo)
        VALUES (@CustomerId, @CustomerName, @ContactInfo);
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

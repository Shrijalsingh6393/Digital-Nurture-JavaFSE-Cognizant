CREATE PROCEDURE SafeTransferFunds
  @FromAccountId INT,
  @ToAccountId INT,
  @Amount MONEY
AS
BEGIN
    SET NOCOUNT ON;
    BEGIN TRY
        BEGIN TRANSACTION;
        -- Check sufficient funds
        IF (SELECT Balance FROM Accounts WHERE AccountID = @FromAccountId) < @Amount
        BEGIN
            THROW 50001, 'Insufficient funds.', 1;
        END;
        UPDATE Accounts SET Balance = Balance - @Amount WHERE AccountID = @FromAccountId;
        UPDATE Accounts SET Balance = Balance + @Amount WHERE AccountID = @ToAccountId;
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

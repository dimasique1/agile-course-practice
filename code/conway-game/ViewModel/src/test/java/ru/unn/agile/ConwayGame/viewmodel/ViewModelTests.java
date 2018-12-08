package ru.unn.agile.ConwayGame.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ViewModelTests {
    private ViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new ViewModel();
    }

    @After
    public void tearDown() {
        viewModel = null;
    }

    @Test
    public void canSetDefaultValues() {
        assertEquals("", viewModel.rowsNumberProperty().get());
        assertEquals("", viewModel.columnsNumberProperty().get());
        assertEquals("", viewModel.firstGenerationProperty().get());
        assertEquals("", viewModel.inputProperty().get());
        assertEquals("", viewModel.outputProperty().get());
        assertEquals(Status.WAITING.toString(), viewModel.getStatus());

    }

    @Test
    public void statusItWaitingWhenBlankFields() {
        viewModel.calculateNextGeneration();

        assertEquals(Status.WAITING.toString(), viewModel.getStatus());
    }

    @Test
    public void statusIsReadyToSetWhenFieldsAreCorrectlyFilled() {
        setInputSizes();

        assertEquals(Status.READY_TO_SET.toString(), viewModel.getStatus());
    }

    @Test
    public void canReportBadFormat() {
        viewModel.rowsNumberProperty().set("q");

        assertEquals(Status.BAD_FORMAT.toString(), viewModel.getStatus());
    }

    @Test
    public void canWaitIfNoAllFieldsAreFilled() {
        viewModel.rowsNumberProperty().set("5");

        assertEquals(Status.WAITING.toString(), viewModel.getStatus());
    }

    @Test
    public void canReportBadFormatWhileSmthgIsBad() {
        viewModel.rowsNumberProperty().set("5");
        viewModel.columnsNumberProperty().set("q");

        assertEquals(Status.BAD_FORMAT.toString(), viewModel.getStatus());
    }

    @Test
    public void isCreateGridDisabledWhileBadFormat() {
        viewModel.rowsNumberProperty().set("5");
        viewModel.columnsNumberProperty().set("q");

        assertTrue(viewModel.isCreationGridDisabled());
    }

    @Test
    public void isCreateGridDisableWhenBlankFields() {
        viewModel.rowsNumberProperty().set("7");

        assertTrue(viewModel.isCreationGridDisabled());
    }

    @Test
    public void isCreateGridDisableWhenBadStatus() {
        viewModel.statusProperty().set(Status.BAD_FORMAT.toString());

        assertTrue(viewModel.isCreationGridDisabled());
    }

    @Test
    public void isCreateGridAbleWithGoodSizes() {
        setInputSizes();

        assertFalse(viewModel.isCreationGridDisabled());
    }

    @Test
    public void isSubmitAble() {
        setInputSizesAndData();

        assertFalse(viewModel.isSubmitionDisabled());
    }

    @Test
    public void isSubmitDisableWhileGenerationIsEmpty() {
        setInputSizes();
        viewModel.firstGenerationProperty().set("");

        assertTrue(viewModel.isSubmitionDisabled());
    }

    @Test
    public void isFirstGenerationLessThenSizes() {
        setInputSizes();
        viewModel.firstGenerationProperty().set("..*");

        assertEquals(Status.READY_TO_SET.toString(), viewModel.getStatus());
    }

    @Test
    public void isFirstGenerationMoreThenSizes() {
        setInputSizes();
        viewModel.firstGenerationProperty().set("..**.");

        assertEquals(Status.BAD_FORMAT.toString(), viewModel.getStatus());
    }

    @Test
    public void isFirstGenerationBadFormat() {
        setInputSizes();
        viewModel.firstGenerationProperty().set("..*k");

        assertEquals(Status.BAD_FORMAT.toString(), viewModel.getStatus());
    }

    @Test
    public void isFirstGenerationGood() {
        setInputSizesAndData();

        assertEquals(Status.READY.toString(), viewModel.getStatus());
    }

    @Test
    public void isSubmitAbleWithGoodData() {
        setInputSizesAndData();

        assertFalse(viewModel.isSubmitionDisabled());
    }

    @Test
    public void  isCorrectInput() {
        viewModel.rowsNumberProperty().set("2");
        viewModel.columnsNumberProperty().set("3");
        viewModel.firstGenerationProperty().set("*.**.*");

        viewModel.calculateNextGeneration();

        assertEquals("*.*\n*.*\n", viewModel.getInput());
    }

    @Test
    public void isCorrectShortOutput() {
        viewModel.rowsNumberProperty().set("1");
        viewModel.columnsNumberProperty().set("1");
        viewModel.firstGenerationProperty().set("*");

        viewModel.calculateNextGeneration();

        assertEquals(".\n", viewModel.getOutput());
    }

    @Test
    public void isCorrectOutput() {
        viewModel.rowsNumberProperty().set("4");
        viewModel.columnsNumberProperty().set("8");
        viewModel.firstGenerationProperty().set("............*......**...........");

        viewModel.calculateNextGeneration();

        assertEquals("........\n...**...\n...**...\n........\n", viewModel.getOutput());
    }

    private void setInputSizes() {
        viewModel.rowsNumberProperty().set("2");
        viewModel.columnsNumberProperty().set("2");
    }

    private void setInputSizesAndData() {
        viewModel.rowsNumberProperty().set("2");
        viewModel.columnsNumberProperty().set("2");
        viewModel.firstGenerationProperty().set(".**.");
    }

}

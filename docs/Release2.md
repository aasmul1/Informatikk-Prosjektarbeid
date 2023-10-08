
## New Features 

In Release 1, we focused on establishing the core structure and functionality of the application (MVN). Therefore, the new features introduced in this release are foundational. These features include:

- **Listeners/Observers**: We implemented the **`NoteOverviewListener`** interface to enable listeners to listen to changes in the **`NoteOverview`** class, and ensuring updates are reflected in the user interface.
- **Added Date to Note**: We enhanced the **`Note`** class by adding date attributes (**`createdDate`** and **`editedDate`**) to track creation and last edit dates for each note.
- **Delete Note Logic**: We implemented logic to delete individual notes from the **`NoteOverview`** based on user interaction.
- **Comparators**: We introduced comparators such as **`CreatedDateComparator`**, **`EditedDateComparator`**, and **`TitleComparator`** to facilitate sorting notes by various criteria in NoteOverview.
- **Edit Note Class**: Implemented an editNote logic with a new controller (**`NoteEditController.java`**) and fxml-fil (**`NoteEdit.fxml`**), that facilitates editing of existing notes. Users can modify note content, ensuring their notes remain up-to-date and relevant.including a new scene (**`NoteEdit.fxml`**) and controller (**`NoteEditController.java`**).



## Architecture

![Image Alt Text](/docs/pictures/architecture.png)

## Work habits 
During this release, we effectively navigated a structured workflow. Every development task is initiated through issues and carried out in its specific branch, ensuring an organized development path. To gauge our progress towards key deliverables, we consistently utilize milestones, this submission is linked to "Innlevering 2" milestone. Crucially, all merge requests must be marked as ready and then undergo thorough peer review to ensure the code's correctness before being approved. Additionally, we champion pair programming, with team members alternating roles, and this collaborative spirit is transparently documented in our commits writing "Co-authored".



## Code quality


For the second release, we aimed to enhance the MVP from the initial release by adding new features such as the possibilty for editing and deleting notes, and sorting the notes based on date or title. We've enriched our test suite with additional tests and introduced UI testing. The project maintains its modularity and is built upon a complete three-layer architecture.

## New Features 

In Release 1, we focused on establishing the core structure and functionality of the application (MVN). Therefore, the new features introduced in this release are foundational. These features include:

- **Added Date to Note**: We enhanced the **`Note`** class by adding date attributes (**`createdDate`** and **`editedDate`**) to track creation and last edit dates for each note.
- **Delete Note**: We implemented logic to delete individual notes from the **`NoteOverview`** based on user interaction.
- **Edit Note**: Implemented editNote logic, with a new controller (**`NoteEditController.java`**) and fxml-file (**`NoteEdit.fxml`**), that facilitates editing of existing notes. Users can modify note content, ensuring their notes remain up-to-date and relevant. 


## Code quality


- **Comparators**: We introduced comparators such as **`CreatedDateComparator`**, **`EditedDateComparator`**, and **`TitleComparator`** to facilitate sorting notes by various criteria in NoteOverview.
- **Listeners/Observers**: We implemented the **`NoteOverviewListener`** and **`NoteListener`** interface in our app to enable real-time updates and maintain code quality. 
    - The AppController class serves as a NoteOverviewListener,  ensures that updates are first applied to the core before being reflected in the user interface. 
    - The NoteOVerview is again a NoteListener. This design facilitates notifications to the NoteOverview whenever an individual note undergoes modifications. 
    - This approach not only guarantees a responsive user interface but also contributes significantly to the overall code quality and user experience.
- **File Manegment**!!!!



## Architecture

![Image Alt Text](/docs/pictures/architecture.png)

For a more detailed description of stucture, see [README](/README.md). 

## Work habits 
During this release, we effectively navigated a structured workflow. Every development task is initiated through issues and carried out in its specific branch, ensuring an organized development path. To gauge our progress towards key deliverables, we consistently utilize milestones, this submission is linked to "Innlevering 2" milestone. Crucially, all merge requests must be marked as ready and then undergo thorough peer review to ensure the code's correctness before being approved. Additionally, we champion pair programming, with team members alternating roles, and this collaborative spirit is transparently documented in our commits writing "Co-authored".





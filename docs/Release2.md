# Realease 2 

For the second release, we aimed to enhance the MVP from the initial release by adding new features such as the possibilty for editing and deleting notes, and sorting the notes based on date or title. We've enriched our test suite with additional tests and introduced UI testing. The project maintains its modularity and is built upon a complete three-layer architecture.

## New Features 

In Release 1, we focused on establishing the core structure and functionality of the application (MVP). Therefore, the new features introduced in this release are significant for the user interface. These features include:

- **Added Date to Note**: We enhanced the **`Note`** class by adding date attributes (**`createdDate`** and **`editedDate`**) to track creation and last edit dates for each note.
- **Delete Note**: We implemented logic to delete individual notes from the **`NoteOverview`** based on user interaction.
- **Edit Note**: Implemented editNote logic, with a new controller (**`NoteEditController.java`**) and fxml-file (**`NoteEdit.fxml`**), that facilitates editing of existing notes. Users can modify note content, ensuring their notes remain up-to-date and relevant.
- **Listeners/Observers** (implementation described under **Code Quality**) 


## Code quality

In Release 2, alongside the introduction of new features, we enhanced the code quality to establish a sturdy and easily maintainable codebase. Here's how we improved our code:

- **Comparators**: We introduced comparators such as **`CreatedDateComparator`**, **`EditedDateComparator`**, and **`TitleComparator`** to facilitate sorting notes by various criteria in NoteOverview.
- **Listeners/Observers**: We implemented the **`NoteOverviewListener`** and **`NoteListener`** interface in our app to enable real-time updates and maintain code quality. 
    - **`AppController`**  acts as a NoteOverviewListener, and **`NoteOverview`** acts as a NoteListener. 
    - Changes in Note will alert NoteOverview, which then alerts AppController. 
    - This ensures that updates are first applied to the core before being reflected in the user interface, and contributes significantly to the overall code quality and user experience. 

  
- **File Management**: Our approach to file management is to implement an implicit storage strategy, ensuring that user data is stored within the application directory. This approach is platform-independent, ensuring versatility across various operating systems and devices. In addition, implicit storage provides a more user-friendly experience by removing the burden of selecting specific storage locations or managing complex document hierarchies.



## Architecture

![Image Alt Text](/docs/pictures/architecture.png)

For a more detailed description of stucture, see [README](/README.md). 

## Work habits 
During this release, we effectively navigated a structured workflow. 

### Milestones, issues and merge requests
Every development task is initiated through issues and carried out in its specific branch, ensuring an organized development path. To gauge our progress towards key deliverables, we consistently utilize milestones, this submission is linked to "Innlevering 2" milestone. 

Crucially, all merge requests must be marked as ready and then undergo thorough peer review to ensure the code's correctness before being approved. 


### Pair programming 
Additionally, we promoted pair programming, with team members alternating roles, and this collaborative is documented in our commits using the "Co-authored" notation. 

Using this approach, we avoid implementing changes that haven't been approved by the rest of the group, resulting in more accurate code. 





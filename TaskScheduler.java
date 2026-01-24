// Simulates a round-robin CPU scheduler using a queue.
// Each task gets a fixed time slice (quantum) to execute.
// If not finished, it goes back to the end of the queue.
public class TaskScheduler {
    
    // Represents a single task with a name and time requirement
    public static class Task {
        private String name;
        private int timeRemaining;
        
        public Task(String name, int totalTime) {
            this.name = name;
            this.timeRemaining = totalTime;
        }
        
        public String getName() {
            return name;
        }
        
        public int getTimeRemaining() {
            return timeRemaining;
        }
        
        public void processTime(int time) {
            timeRemaining -= time;
        }
        
        public boolean isFinished() {
            return timeRemaining <= 0;
        }
    }
    
    private QueueDS<Task> taskQueue;
    private int timeQuantum;
    
    // Creates a new scheduler with specified time quantum
    public TaskScheduler(int quantum) {
        this.taskQueue = new QueueDS<>();
        this.timeQuantum = quantum;
    }
    
    // Adds a task to the scheduler queue
    public void addTask(Task task) {
        taskQueue.enqueue(task);
    }
    
    // Runs the round-robin scheduling algorithm
    public void run() {
        System.out.println("Starting Round-Robin Scheduler");
        System.out.println("Time Quantum: " + timeQuantum + " units");
        
        while (!taskQueue.isEmpty()) {
            // Get the next task from the front of the queue
            Task currentTask = taskQueue.dequeue();
            
            // Determine how much time this task will get
            int timeToRun;
            if (currentTask.getTimeRemaining() <= timeQuantum) {
                timeToRun = currentTask.getTimeRemaining();
            } else {
                timeToRun = timeQuantum;
            }
            
            // Process the task
            currentTask.processTime(timeToRun);
            int remaining = currentTask.getTimeRemaining();
            
            // Print what happened
            System.out.println("Running " + currentTask.getName() + 
                             " (" + timeToRun + " units, " + 
                             remaining + " left)");
            
            // If task isn't finished, put it back in the queue
            if (!currentTask.isFinished()) {
                taskQueue.enqueue(currentTask);
            }
        }
        
        System.out.println("All tasks completed!");
    }
    
    // Main method to demonstrate the scheduler
    public static void main(String[] args) {
        // Create a scheduler with quantum of 3
        TaskScheduler scheduler = new TaskScheduler(3);
        
        // Add some tasks
        scheduler.addTask(new Task("Task A", 5));
        scheduler.addTask(new Task("Task B", 8));
        scheduler.addTask(new Task("Task C", 2));
        
        // Run the scheduler
        scheduler.run();
    }
}
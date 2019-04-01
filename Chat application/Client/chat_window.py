import tkinter as tk

def create_chat_window():
    main_window = tk.Tk()
    main_window.geometry('420x640')
    main_window.title('Chat window')
    create_chat_controls(main_window)
    main_window.mainloop()

def create_chat_controls(window):
    top_frame = tk.Frame(window,relief=tk.GROOVE, bg = 'green', height=500, width=400)
    bottom_frame = tk.Frame(window,bg='white', height=100, width=400)
    conversation_view = tk.Listbox(top_frame)
    top_frame.place(x=10, y=10)
    bottom_frame.place(x=10, y=510)

if __name__ == '__main__':
	create_chat_window()
    
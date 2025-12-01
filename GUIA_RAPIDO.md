# 🚀 Guia Rápido - 5 Minutos

## 📥 Baixar Projeto no Android Studio

### **Método Rápido:**

1. **Abrir Android Studio**
2. **Get from VCS**
3. **URL:** `https://github.com/Pedro-Granato/VidaIF.git`
4. **Clone**

---

## 🔄 Atualizar Projeto (Pull)

### **Terminal do Android Studio (Alt+F12):**

```bash
# Trocar para branch com melhorias
git checkout claude/carousel-auto-links-011ugdYcUVnZ2NrmMQvymBdS

# Atualizar
git pull
```

---

## ✏️ Editar URLs dos Links

### **Arquivo:** `app/src/main/java/br/edu/ifsp/vidaif/fragment/HomeFragment.kt`

**Carrossel (linha ~57):**
```kotlin
Banner(
    imageRes = R.drawable.banner1,
    url = "https://sua-url-aqui.com"  // 👈 TROCAR AQUI
)
```

**Destaques (linha ~117):**
```kotlin
Destaque(
    title = "Título",
    imageRes = R.drawable.destaque1,
    url = "https://sua-url-aqui.com"  // 👈 TROCAR AQUI
)
```

---

## 💾 Salvar Mudanças (Commit + Push)

### **Terminal:**

```bash
# Ver o que mudou
git status

# Adicionar tudo
git add .

# Commit
git commit -m "Atualizar URLs dos links"

# Push
git push
```

---

## 🔀 Criar Pull Request

### **No GitHub:**

1. Ir para: **https://github.com/Pedro-Granato/VidaIF**
2. Clicar em **"Compare & pull request"**
3. Preencher título e descrição
4. **"Create pull request"**
5. **"Merge pull request"**

---

## ▶️ Executar App

1. Conectar celular OU criar emulador
2. Clicar em **▶️ Run** (Shift+F10)
3. Aguardar instalação

---

## 🎯 Comandos Essenciais

```bash
# Ver status
git status

# Atualizar do GitHub
git pull

# Adicionar arquivos
git add .

# Commit
git commit -m "Sua mensagem"

# Enviar para GitHub
git push

# Ver branches
git branch -a

# Trocar branch
git checkout nome-da-branch

# Ver histórico
git log --oneline -10
```

---

## 📱 Onde Trocar URLs

| Item | Arquivo | Linha |
|------|---------|-------|
| **Carrossel** | `HomeFragment.kt` | ~57 |
| **Destaques** | `HomeFragment.kt` | ~117 |

---

## ⚙️ Ajustar Velocidade do Carrossel

**Arquivo:** `HomeFragment.kt` (linha ~87)

```kotlin
autoScrollHandler?.postDelayed(this, 3500)  // 👈 Milissegundos
```

**Valores sugeridos:**
- `2000` = 2 segundos (rápido)
- `3500` = 3.5 segundos (padrão)
- `5000` = 5 segundos (lento)

---

## ✅ Checklist Rápido

- [ ] Clonar repositório
- [ ] Trocar para branch `claude/carousel-auto-links-011ugdYcUVnZ2NrmMQvymBdS`
- [ ] Editar URLs em `HomeFragment.kt`
- [ ] Testar no app
- [ ] Commit + Push
- [ ] Criar Pull Request
- [ ] Merge para main

---

## 🆘 Problema?

**App não compila:**
```bash
File → Invalidate Caches → Invalidate and Restart
```

**Conflito no Git:**
```bash
git pull
# Resolver conflitos manualmente
git add .
git commit -m "Resolver conflitos"
```

**Precisa desfazer mudança:**
```bash
git checkout -- arquivo.kt
```

---

Para guia completo, veja: **`GUIA_ANDROID_STUDIO.md`**
